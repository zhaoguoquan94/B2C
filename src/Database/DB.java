package Database;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import model.*;

/**
 * 数据库操作类 大家凡是用到数据库的话都这样写： DB db=DB.getInstance(); db.someMethod();
 * 
 * @author 赵国铨
 * 
 */
public class DB {
	private static DB db = new DB();

	public static DB getInstance() {
		if (db != null) {
			return db;
		} else {
			db = new DB();
			return db;
		}
	}

	public static void main(String[] args) {
		// for testing
	}

	private Connection connection;
	// private PreparedStatement preparedStatement;
	private Logger logger;
	private DB() {
		try {
			logger = Logger.getLogger("DBLogger");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/b2c", "root", "");
			// Statement s=con.createStatement();
			logger.info("connection set");
			// ResultSet rsTables = connection.getMetaData().getTables(null,
			// null, "student", null);
			// if(rsTables.next()){
			// logger.info("student table already exsit");
			// } else {
			// Statement s=connection.createStatement();
			// s.executeUpdate("create table student (sid Integer,name text,gender text,age Integer,classNum Integer,password text,birthDate date);");
			// logger.fine("create student success");
			//
			// }
			// rsTables.close();
			// rsTables = connection.getMetaData().getTables(null, null,
			// "Admin", null);
			// if(rsTables.next()){
			// logger.info("admin table already exsit");
			// } else {
			// Statement s=connection.createStatement();
			// s.executeUpdate("create table admin (aid Integer,password text);");
			// s.executeUpdate("insert into admin values(1,'admin')");
			// logger.fine("create admin success");
			// }
			// rsTables.close();
			// rsTables = connection.getMetaData().getTables(null, null,
			// "score", null);
			// if(rsTables.next()){
			// logger.info("score table already exsit");
			// } else {
			// Statement s=connection.createStatement();
			// s.executeUpdate("create table score (aid Integer,className text,score float);");
			// // s.execute("insert into admin values(1,'admin')");
			// logger.fine("create socre success");
			// }
			// rsTables.close();
			// connection.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除管理员
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param admin
	 * @return
	 */
	@Deprecated
	public Integer deleteNBAdmin(NBAdmin admin) {
		return 0;
	}

	/**
	 * 删除类别
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param c
	 * @return
	 */
	@Deprecated
	public Integer deleteNBCategory(NBCategory c) {
		return 0;
	}

	/**
	 * 删除订单 级联删除相对应 的info信息
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param order
	 *            要删除的订单
	 * @return 是否成功
	 */
	public Integer deleteNBOrder(NBOrder order) {
		try {
			ArrayList<NBOrderInfo> infos = getNBOrderInfosByNBOrderID(order
					.getOrderID());
			for (NBOrderInfo i : infos) {
				deleteNBOrderInfo(i);
				logger.info("delete orderinfo" + i);
			}
			PreparedStatement p = connection
					.prepareStatement("delete from  nbvipcategory where orderid=?");
			p.setInt(1, order.getOrderID());
			p.execute();
			logger.info("delete order success");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("delete order失败");
		}
		return 0;
	}

	/**
	 * 删除Orderinfo信息，由参数决定删哪个
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderInfo
	 *            要删这个orderInfo
	 * @return 1成功 0失败
	 */
	public Integer deleteNBOrderInfo(NBOrderInfo orderInfo) {
		try {

			PreparedStatement p = connection
					.prepareStatement("delete from nborderinfo where orderID=? and productID=?");
			p.setInt(3, orderInfo.getOrderID());
			p.setInt(4, orderInfo.getProductID());
			p.execute();
			logger.info(" delete orderinfo: success" + orderInfo);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("delete orderinfo" + orderInfo + " faild");
		}
		return null;
	}

	/**
	 * 删除产品
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param product
	 * @return
	 */
	public Integer deleteNBProduct(NBProduct product) {
		try {
			PreparedStatement p = connection
					.prepareStatement("delete from  nbproduct where id=?");
			p.setInt(1, product.getId());
			p.execute();
			logger.info("delete product success");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("delete product失败");
		}
		return 0;
	}

	/**
	 * 删除评论
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param comment
	 * @return
	 */
	@Deprecated
	public Integer deleteNBProductComment(NBProductComment comment) {
		return 0;
	}

	/**
	 * 删除用户
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param user
	 * @return
	 */
	@Deprecated
	public Integer deleteNBUser(NBUser user) {
		try {

			PreparedStatement p = connection
					.prepareStatement("delete from  NBUser where id=?");
			p.setInt(1, user.getId());
			p.execute();
			logger.info("delete user success");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("delete user失败");
		}
		return 0;
	}

	/**
	 * 通过提供原来的addressID删除用户送货地址
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param address
	 *            希望删除的地址对象
	 * @return 1成功 0失败
	 */
	public Integer deleteNBUserAddress(int userAddressID) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbuseraddress "
							+ "set isActive=? " + " where useraddressID=?");
			p.setInt(1, 0);
			p.setInt(2, userAddressID);
			p.execute();
			logger.info("delete address success ,userAddressid="
					+ userAddressID);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("delete this userAdderess failed " + userAddressID);
		}
		return 0;
	}

	/**
	 * 通过提供原来的对象删除用户送货地址
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param address
	 *            希望删除的地址对象
	 * @return 1成功 0失败
	 */
	public Integer deleteNBUserAddress(NBUserAddress address) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbuseraddress "
							+ "set isActive=? " + " where useraddressID=?");
			p.setInt(1, 0);
			p.setInt(2, address.getUserAddressID());
			p.execute();
			logger.info("delete address success " + address);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 删除会员级别
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param vipCategory
	 * @return
	 */
	@Deprecated
	public Integer deleteNBVIPCategory(NBVIPCategory vipCategory) {
		try {
			PreparedStatement p = connection
					.prepareStatement("delete from nbvipcategory where id=?");

			p.setInt(1, vipCategory.getID());

			p.execute();
			logger.info("delete vipCate success" + vipCategory);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("delete this vipcate failed " + vipCategory);
		}
		return 0;
	}

	//TODO get category by name id
	
	/**
	 * 得到全部Category，每个category的父category的位置是这个返回值的ArrayList的对应的位置
	 * 比如教材的父亲id是1，那么getNBCategory.get
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @return
	 */
	public ArrayList<NBCategory> getNBCategorys() {
		ArrayList<NBCategory> list = new ArrayList<NBCategory>(100);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from NBCategory;");
			ResultSet rs = p.executeQuery();
			int maxID = 0;
			while (rs.next()) {
				NBCategory tempCateory = new NBCategory(rs.getInt(1),
						rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));
				list.add(tempCateory);
				maxID = maxID > tempCateory.getID() ? maxID : tempCateory
						.getID();

			}
			for (NBCategory temp : list) {
				// TODO
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * 通过orderID得到NBOrder对象
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderID
	 * @return NBOrder对象
	 */
	public NBOrder getNBOrder(Integer orderID) {

		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nborder where orderid=?");
			p.setInt(1, orderID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrder tempOrder = new NBOrder(rs.getInt(1), rs.getInt(2),
						new java.util.Date(rs.getDate(3).getTime()),
						rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getDouble(7));

				logger.info("order selected " + tempOrder);
				return tempOrder;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("get  order" + orderID + "failed");
		}
		return null;
	}

	/**
	 * 获得全部NBOrderInfo
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @return NBOrderInfo 的arrayLIst null为获取失败
	 */
	public ArrayList<NBOrderInfo> getNBOrderInfos() {
		ArrayList<NBOrderInfo> orderInfos = new ArrayList<NBOrderInfo>(400);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nborderinfo");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrderInfo temp = new NBOrderInfo(rs.getInt(1), rs.getInt(2),
						rs.getInt(3));
				orderInfos.add(temp);
				logger.info("orderINfo added" + temp);
			}
			logger.info("all orderinfo selected");
			return orderInfos;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("get add orderinfo faild");
		}
		return null;

	}

	/**
	 * 通过orderID得到全部相关订单信息
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderID
	 *            int 订单的id
	 * @return 全部orderID的相关订单信息的arraylist null为失败
	 */
	public ArrayList<NBOrderInfo> getNBOrderInfosByNBOrderID(Integer orderID) {
		ArrayList<NBOrderInfo> orderInfos = new ArrayList<NBOrderInfo>(400);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nborderinfo where orderid=?");
			p.setInt(1, orderID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrderInfo temp = new NBOrderInfo(rs.getInt(1), rs.getInt(2),
						rs.getInt(3));
				orderInfos.add(temp);
				logger.info("orderINfo added" + temp);
			}
			logger.info("all orderinfo selected");
			return orderInfos;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("get " + orderID + "'s orderinfo faild");
		}
		return null;
	}

	/**
	 * 得到productID指定的商品的所有订单信息
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param productID
	 * @return productID指定的商品的所有订单信息
	 */
	public ArrayList<NBOrderInfo> getNBOrderInfosByNBProductID(Integer productID) {
		ArrayList<NBOrderInfo> orderInfos = new ArrayList<NBOrderInfo>(400);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nborderinfo where productid=?");
			p.setInt(1, productID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrderInfo temp = new NBOrderInfo(rs.getInt(1), rs.getInt(2),
						rs.getInt(3));
				orderInfos.add(temp);
				logger.info("orderINfo added" + temp);
			}
			logger.info("all orderinfo selected");
			return orderInfos;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get product " + productID + " 's orderinfo faild");
		}
		return null;
	}

	/**
	 * 计算订单价格
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderID
	 * @return 订单价格
	 */
	public Double getNBOrderPriceByOrderID(Integer orderID) {
		ArrayList<NBOrderInfo> orderInfos = getNBOrderInfosByNBOrderID(orderID);
		double price = 0.0;
		for (NBOrderInfo o : orderInfos) {
			NBProduct p = getNBProductByID(o.getProductID());
			price += p.getDiscount() * p.getPrice() * o.getNumber();
		}
		return price;
	}

	/**
	 * 得到全部订单
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @return 订单的ArrayLIst
	 */
	public ArrayList<NBOrder> getNBOrders() {
		ArrayList<NBOrder> list = new ArrayList<NBOrder>(1000);
		Statement s;
		try {
			s = connection.createStatement();
			ResultSet rs = s.executeQuery("select * from NBOrder");
			while (rs.next()) {
				NBOrder tempOrder = new NBOrder(rs.getInt(1), rs.getInt(2),
						new java.util.Date(rs.getDate(3).getTime()),
						rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getDouble(7));
				list.add(tempOrder);
				logger.info("order add " + tempOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get all orders failed");
		}
		return null;

	}

	/**
	 * 通过email得到用户的全部订单
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param email
	 * @return 该用户的全部订单
	 */
	public ArrayList<NBOrder> getNBOrdersByUserEmail(String email) {
		try {
			ArrayList<NBOrder> orders = new ArrayList<NBOrder>();
			NBUser user = getNBUserByEmail(email);
			PreparedStatement p = connection
					.prepareStatement("select * from nborder where userID=?");
			p.setInt(1, user.getId());
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrder tempOrder = new NBOrder(rs.getInt(1), rs.getInt(2),
						new java.util.Date(rs.getDate(3).getTime()),
						rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getDouble(7));
				orders.add(tempOrder);
				logger.info("order selected " + tempOrder);
			}
			logger.info("all orders belongs to " + user + " was selected");
			return orders;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("get this user's orders " + email + "failed");
		}
		return null;
	}

	/**
	 * 得到某用户的在末段时间的所有订单
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param email
	 *            用户email
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return ordre的ArrayList null 为失败
	 */
	public ArrayList<NBOrder> getNBOrdersByUserEmailAndDateRange(String email,
			java.util.Date startDate, java.util.Date endDate) {
		try {
			ArrayList<NBOrder> orders = new ArrayList<NBOrder>();
			NBUser user = getNBUserByEmail(email);
			PreparedStatement p = connection
					.prepareStatement("select * from nborder where userID=?");
			p.setInt(1, user.getId());
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrder tempOrder = new NBOrder(rs.getInt(1), rs.getInt(2),
						new java.util.Date(rs.getDate(3).getTime()),
						rs.getInt(4), rs.getInt(5), rs.getInt(6),
						rs.getDouble(7));
				if (tempOrder.getOrderDate().after(startDate)
						&& tempOrder.getOrderDate().before(endDate))
					;
				orders.add(tempOrder);

				logger.info("order selected " + tempOrder);
			}
			logger.info("all orders belongs to " + user
					+ " in time range was selected");
			return orders;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("get this user's orders " + email + "failed");
		}
		return null;
	}

	public ArrayList<NBOrderWrap> getNBOrderWrapsByDateRange(
			java.util.Date startDate, java.util.Date endDate) {
		try {
			ArrayList<NBOrderWrap> orders = new ArrayList<NBOrderWrap>();

			PreparedStatement p = connection
					.prepareStatement("select * from nborder where orderDate>? and orderDate<?");
			p.setDate(1, new java.sql.Date(startDate.getTime()));
			p.setDate(2, new java.sql.Date(endDate.getTime()));

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBOrderWrap tempWrap = new NBOrderWrap(rs.getInt(1));
				orders.add(tempWrap);
				logger.info("orderWrap selected " + tempWrap);
			}
			logger.info("all orderWraps in time range was selected");
			return orders;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("get orderWrap in date Range failed");
		}
		return null;
	}

	/**
	 * 按照id得到产品对象
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param id
	 * @return null表示失败
	 */
	public NBProduct getNBProductByID(Integer id) {
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nbproduct where id=?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBProduct temp = new NBProduct(rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
				logger.info("NBProduct get:" + temp);
				return temp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get product falied:" + id);
		}
		return null;

	}

	/**
	 * 按照productID得到商品评论
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param productID
	 * @return
	 */
	public ArrayList<NBProductComment> getNBProductCommentsByProductID(
			Integer productID) {
		ArrayList<NBProductComment> productComment = new ArrayList<NBProductComment>(
				100);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nbproductcomment where productID=?");
			p.setInt(1, productID);

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBProductComment com = new NBProductComment(rs.getInt(1),
						rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));

				productComment.add(com);
				logger.info("NBProductComment get:" + com);

			}
			logger.info("get productComment name success" + productComment);
			return productComment;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get productComment list falied:");
		}
		return null;
	}

	/**
	 * 按照email得到这个用户 的评论
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param email
	 * @return
	 */
	public ArrayList<NBProductComment> getNBProductCommentsByUserEmail(
			String email) {
		ArrayList<NBProductComment> productComment = new ArrayList<NBProductComment>(
				100);
		try {
			NBUser user = getNBUserByEmail(email);
			PreparedStatement p = connection
					.prepareStatement("select * from nbproductcomment where userID=?");
			p.setInt(1, user.getId());

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBProductComment com = new NBProductComment(rs.getInt(1),
						rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));

				productComment.add(com);
				logger.info("NBProductComment get:" + com);

			}
			logger.info("get " + user + " 's productComment name success"
					+ productComment);
			return productComment;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get " + email + " 's productComment list falied:");
		}
		return null;
	}

	/**
	 * 取出所有product
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @return
	 */
	public ArrayList<NBProduct> getNBProducts() {
		ArrayList<NBProduct> product = new ArrayList<NBProduct>(1000);
		PreparedStatement p;
		try {
			p = connection.prepareStatement("select * from nbproduct;");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBProduct temp = new NBProduct(rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
				product.add(temp);
				logger.info("get an nbproduct :" + temp);

			}
			return product;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.severe("get all product failed");
		}
		return null;

	}

//	public ArrayList<NBProduct> getNBProductsByCategory(NBCategory name) {
//		// TODO
//
//	}

	/**
	 * 商品搜索功能，提供like级别的查询服务
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param name
	 *            需要查询的关键字
	 * @return ArrayList<NBProduct>
	 */
	public ArrayList<NBProduct> getNBProductsByName(String name) {
		ArrayList<NBProduct> product = new ArrayList<NBProduct>(100);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nbproduct where name like '%?%'");

			p.setString(1, name);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBProduct temp = new NBProduct(rs.getInt(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
				product.add(temp);
				logger.info("NBProduct get:" + temp);

			}
			logger.info("get product name like this " + name + " success"
					+ product.toString());
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get product list falied:");
		}
		return null;
	}

	/**
	 * 得到全部地址，不包括已经“删除的”
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @return
	 */
	public ArrayList<NBUserAddress> getNBUserAddress() {
		ArrayList<NBUserAddress> addresses = new ArrayList<NBUserAddress>();
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nbuseraddress");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBUserAddress temp = new NBUserAddress(rs.getInt(1),
						rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8));
				if (temp.getIsActive() == 1)
					addresses.add(temp);
				logger.info(temp.toString());
			}
			logger.info("get all address success");
			return addresses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过userAddressID得到address 之前忘了加了
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param addressID
	 * @return NBUserAddress对象
	 */
	public NBUserAddress getNBUserAddressByID(int addressID) {

		try {

			PreparedStatement p = connection.prepareStatement(""
					+ "select * from nbuseraddress where userAddressID=?");
			p.setInt(1, addressID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBUserAddress temp = new NBUserAddress(rs.getInt(1),
						rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8));

				logger.info(temp.toString());
				return temp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.severe("get useraddress by id failed");
		return null;
	}

	/**
	 * 获取email对应用户的所有地址信息
	 * 
	 * @author 赵国铨
	 * @param email
	 *            email
	 * @return email对应用户的所有地址信息
	 */
	public ArrayList<NBUserAddress> getNBUserAddressesByUserEmail(String email) {
		ArrayList<NBUserAddress> addresses = new ArrayList<NBUserAddress>();
		try {
			NBUser user = getNBUserByEmail(email);
			int userID = user.getId();
			PreparedStatement p = connection
					.prepareStatement("select * from nbuseraddress where userID=?");
			p.setInt(1, userID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBUserAddress temp = new NBUserAddress(rs.getInt(1),
						rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8));
				if (temp.getIsActive() == 1)
					addresses.add(temp);
				logger.info(temp.toString());
			}

			return addresses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// insert section
	// containing insert SQL

	/**
	 * 通过email获取用户地址 ，包括已经删除的地址
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param email
	 * @return 用户地址的ArrayList
	 * 
	 */
	public ArrayList<NBUserAddress> getNBUserAddressesByUserEmailIncludingInactive(
			String email) {
		ArrayList<NBUserAddress> addresses = new ArrayList<NBUserAddress>();
		try {
			NBUser user = getNBUserByEmail(email);
			int userID = user.getId();
			PreparedStatement p = connection
					.prepareStatement("select * from nbuseraddress where userID=?");
			p.setInt(1, userID);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBUserAddress temp = new NBUserAddress(rs.getInt(1),
						rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8));
				addresses.add(temp);
				logger.info(temp.toString());
			}

			return addresses;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过email得到User对象
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param email
	 * @return
	 */
	public NBUser getNBUserByEmail(String email) {
		// remember to set level string
		// using getNBVIPCategoryByscore
		PreparedStatement p;
		try {
			// p=connection.prepareStatement("select * from nbvipcategory where ")
			p = connection.prepareStatement("select * from nbuser where"
					+ "email=?");
			p.setString(1, email);
			ResultSet rs = p.executeQuery();
			rs.next();
			NBUser user = new NBUser(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					new java.util.Date(rs.getDate(6).getTime()), null);
			// !!!setlevel!!!
			user.setLevel(getNBVIPCategoryByNBUserEmail(email).getLevelName());
			logger.info("user:" + user + "selected,level wrote");
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("user :" + email + "is not selected,failed");
		}
		return null;

	}

	/**
	 * 通过ID得到NBUser对象
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param id
	 * @return
	 */
	public NBUser getNBUserByID(Integer id) {
		PreparedStatement p;
		try {
			// p=connection.prepareStatement("select * from nbvipcategory where ")
			p = connection.prepareStatement("select * from nbuser where"
					+ "id=?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			NBUser user = new NBUser(id, rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getInt(5), new java.util.Date(rs
							.getDate(6).getTime()), null);
			// !!!setlevel!!!
			user.setLevel(getNBVIPCategoryByNBUserEmail(user.getEmail())
					.getLevelName());
			logger.info("user:" + user + "selected,level wrote");
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("user :" + id + "is not selected,failed");
		}
		return null;

	}

	/**
	 * 得到全部用户对象
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @return
	 */
	public ArrayList<NBUser> getNBUsers() {
		PreparedStatement p;
		ArrayList<NBUser> users = new ArrayList<NBUser>(1000);
		try {
			p = connection.prepareStatement("select * from nbuser");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				rs.next();
				NBUser user = new NBUser(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getInt(5),
						new java.util.Date(rs.getDate(6).getTime()), null);
				// !!!setlevel!!!
				user.setLevel(getNBVIPCategoryByNBUserEmail(user.getEmail())
						.getLevelName());
				logger.info("user:" + user + "selected,level wrote");
				users.add(user);
			}

			return users;

		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("selecte all user failed");
		}
		return null;
	}

	/**
	 * 根据email得到某个用户的会员级别
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param email
	 * @return 会员级别对象
	 */
	public NBVIPCategory getNBVIPCategoryByNBUserEmail(String email) {
		// return null;
		NBUser user = getNBUserByEmail(email);
		if (user != null) {
			return getNBVIPCategoryByScore(user.getScore());
		}
		return null;
	}

	// TODO 记得在数据库中添加相应表项
	/**
	 * 根据积分得到级别NBVIPCategory对象不然无法执行这个函数
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param score
	 *            积分
	 * @return
	 */
	public NBVIPCategory getNBVIPCategoryByScore(Integer score) {
		ArrayList<NBVIPCategory> cate = new ArrayList<NBVIPCategory>(20);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from NBVIPCategory");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				cate.add(new NBVIPCategory(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getDouble(4)));
			}
			NBVIPCategory selected = cate.get(0);
			for (NBVIPCategory temp : cate) {
				if (temp.getLeastScore() > new Integer(score)) {
					continue;
				} else {
					if (temp.getLeastScore() < selected.getLeastScore()) {
						// select this because it is less
						selected = temp;
					} else {
						// continue
						continue;
					}
				}
			}
			logger.info("getNBVIPCategoryByScore success" + selected);
			return selected;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("getNBVIPCategoryByScore failed");
		}
		return null;
	}

	/**
	 * 得到数据库中全部comment
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @return
	 */
	public ArrayList<NBProductComment> getProductComments() {
		ArrayList<NBProductComment> productComment = new ArrayList<NBProductComment>(
				1000);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from nbproductcomment");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBProductComment com = new NBProductComment(rs.getInt(1),
						rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5));
				productComment.add(com);
				logger.info("NBProductComment get:" + com);

			}
			logger.info("get all productComment  success" + productComment);
			return productComment;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("get all productComment list falied:");
		}
		return null;

	}

	/**
	 * 得到全部VIP category，未经排序。
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @return
	 */
	public ArrayList<NBVIPCategory> getVIPCategorys() {
		ArrayList<NBVIPCategory> cate = new ArrayList<NBVIPCategory>(20);
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from NBVIPCategory");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				cate.add(new NBVIPCategory(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getDouble(4)));
			}
			logger.info("get all vipcategory success");
			return cate;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		logger.severe("get all vip category failed");
		return null;
	}

	@Deprecated
	/**
	 * 插入管理员
	 * @author 赵国铨
	 * 2014年6月26日
	 * @param admin
	 * @return
	 */
	Integer insertNBAdmin(NBAdmin admin) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into nbadmin values(?,?)");
			p.setString(1, admin.getUsername());
			p.setString(2, admin.getPassword());
			p.execute();
			logger.severe("插入管理员成功" + admin);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("插入管理员失败" + admin);
			return 0;
		}

	}

	/**
	 * 插入类别
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param c
	 * @return 1成功 0失败
	 */
	public Integer insertNBCategory(NBCategory c) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into NBcategory values(null,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			p.setString(1, c.getName());
			p.setInt(2, c.getFatherID());
			p.setString(3, c.getDescription());
			p.setString(4, c.getImagePath());
			p.execute();
			logger.severe("插入category成功" + c);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("插入category失败" + c);
			return 0;
		}
	}

	/**
	 * 插入order
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param order
	 * @return
	 */
//	public Integer insertNBOrder(NBOrder order) {
//		try {
//			PreparedStatement p = connection
//					.prepareStatement("insert into NBOrder values(null,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
//			p.setInt(1, order.getUserID());
//			p.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
//			p.setInt(3, order.getState());
//			p.setInt(4, order.getScoreGet());
//			p.setInt(5, order.getUserAddressID());
//			p.execute();
//			logger.info("插入order成功" + order);
//			
//			return p.getGeneratedKeys();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			logger.severe("插入order失败" + order);
//			return 0;
//		}
//	}

	/**
	 * 插入orderInfo
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderInfo
	 *            要插入的对象
	 * @return
	 */
	public Integer insertNBOrderInfo(NBOrderInfo orderInfo) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into nborderinfo values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, orderInfo.getOrderID());
			p.setInt(2, orderInfo.getProductID());
			p.setInt(4, orderInfo.getNumber());
			p.execute();

			logger.info(" orderinfo inserted:" + orderInfo);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("insert " + orderInfo + "faild");
		}
		return null;
	}

	/**
	 * 插入product
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param product
	 * @return
	 */
	public Integer insertNBProduct(NBProduct product) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into NBproduct values(null,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, product.getCategoryID());
			p.setString(2, product.getDescrition());
			p.setString(3, product.getImagePath());
			p.setDouble(4, product.getPrice());
			p.setDouble(5, product.getDiscount());
			p.setInt(6, product.getNumberLeft());
			p.execute();

			logger.info(" product inserted:" + product);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("insert pruduct" + product + "faild");
		}
		return null;

	}

	/**
	 * 插入评论
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param comment
	 * @return
	 */
	public Integer insertNBProductComment(NBProductComment comment) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into nbproductcomment values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, comment.getUserID());
			p.setInt(2, comment.getProductID());
			p.setInt(3, comment.getLevel());
			p.setString(4, comment.getTitle());
			p.setString(5, comment.getContent());
			p.execute();
			logger.info(" productcomment inserted:" + comment);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("insert pruductcomment" + comment + "faild");
		}
		return null;
	}

	/**
	 * 插入用户
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param user
	 * @return
	 */
	public Integer insertNBUser(NBUser user) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into NBUser values"
							+ "(null,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			p.setString(1, user.getEmail());
			p.setString(2, user.getNickname());
			p.setString(3, user.getPassword());
			p.setInt(4, user.getScore());
			p.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
			p.execute();
			logger.info("insert user success" + user);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("insert user faild" + user);
		}
		return 0;
	}

	/**
	 * 插入用户地址
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param address
	 *            NBUserAddress对象 useraddressID ,isactive无需提供，任意值即可
	 * @return 1,0
	 */
	public Integer insertNBUserAddress(NBUserAddress address) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into nbuserAddress values"
							+ "(null,?,?,?,?,?,1)",Statement.RETURN_GENERATED_KEYS);
			p.setInt(1, address.getUserID());
			p.setString(2, address.getReceiverName());
			p.setString(3, address.getAddress());
			p.setString(4, address.getPostCode());
			p.setString(5, address.getTelephone());
			p.setString(6, address.getMobilePhone());
			// is active
			p.execute();
			logger.info("insert useraddress success" + address.toString());
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("useraddress 插入失败" + address);
		}
		return 0;
	}

	/**
	 * 插入用户会员级别
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param vipCategory
	 * @return
	 */
	public Integer insertNBVIPCategory(NBVIPCategory vipCategory) {
		try {
			PreparedStatement p = connection
					.prepareStatement("insert into nbvipcategory values"
							+ "(null,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			p.setString(1, vipCategory.getLevelName());
			p.setInt(2, vipCategory.getLeastScore());
			p.setDouble(3, vipCategory.getScorePercentage());
			p.execute();
			logger.info("insert nbvipcategory success" + vipCategory);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("nbvipcategory 插入失败" + vipCategory);
		}
		return 0;
	}

	// update section
	// includeing UPDATE SQL
	@Deprecated
	/**
	 * 更新管理员密码，不推荐使用
	 * @author 赵国铨
	 * 2014年6月26日
	 * @param username
	 * @param newAdmin
	 * @return 0是失败
	 */
	public Integer updateNBAdmin(String username, NBAdmin newAdmin) {
		return 0;
	}

	public Integer updateNBCategory(Integer categoryID, NBCategory newCategory) {
		return 0;
		// TODO 最后实现

	}

	/**
	 * 修改订单信息，只能修改state,score,userAddressID
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderID
	 *            需要修改的orderID
	 * @param newOrder
	 *            新的order对象
	 * @return 1成功 0失败
	 */
	public Integer updateNBOrder(Integer orderID, NBOrder newOrder) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nborder "
							+ " set state=? ,scoreGet=?,userAddressID=?,where orderid=?");
			p.setInt(1, newOrder.getState());
			p.setInt(2, newOrder.getScoreGet());
			p.setInt(3, newOrder.getUserAddressID());
			p.setInt(4, newOrder.getOrderID());
			p.execute();
			logger.info("update orderinfo fine :" + newOrder);
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("update order " + newOrder + " failed");
		}
		return null;
	}

	/**
	 * 只更改order和product确定的订单的数量
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderID
	 * @param productID
	 * @param newNum
	 *            希望更新的数量
	 * @return 1成功更新 0失败
	 */
	public Integer updateNBOrderInfo(Integer orderID, Integer productID,
			int newNumber) {
		try {

			PreparedStatement p = connection
					.prepareStatement("update nborderinfo set number=? where orderID=? and productID=?");
			p.setInt(2, newNumber);
			p.setInt(3, orderID);
			p.setInt(4, productID);
			p.execute();

			logger.info(" orderinfo updated:orderid: " + orderID
					+ "  producctid:" + productID);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("update faild");
		}
		return null;
	}

	// delete section

	/**
	 * 更新NBOrderInfo，其实我觉得主要是更新数量，productID没什么改的需求
	 * 
	 * @author 赵国铨 2014年6月25日
	 * @param orderID
	 *            对应的order
	 * @param productID
	 *            对应的product
	 * @param newOrderInfo
	 *            新的OrderInfo对象
	 * @return 1成功更新 0失败
	 */
	public Integer updateNBOrderInfo(Integer orderID, Integer productID,
			NBOrderInfo newOrderInfo) {
		try {

			PreparedStatement p = connection
					.prepareStatement("update nborderinfo set productID=?,number=? where orderID=? and productID=?");
			p.setInt(1, newOrderInfo.getProductID());
			p.setInt(2, newOrderInfo.getNumber());
			p.setInt(3, orderID);
			p.setInt(4, productID);
			p.execute();

			logger.info(" orderinfo updated:" + newOrderInfo);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("update " + newOrderInfo + "faild");
		}
		return null;
	}

	public Integer updateNBProduct(Integer productID, NBProduct newProduct) {
		return 0;
	}

	/**
	 * 更新用户信息，nickname和password 不需要提供原始 password的方法。
	 * 
	 * @param email
	 * @param newUser
	 * @return
	 */
	public Integer updateNBUser(String email, NBUser newUser) {
		try {
			PreparedStatement p = connection.prepareStatement("update nbuser "
					+ "set nickname=? ,password=? where email=?");
			p.setString(1, newUser.getNickname());
			p.setString(2, newUser.getPassword());
			p.setString(3, email);
			p.execute();
			logger.info("update user success " + newUser);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("update user failed" + newUser);
		}
		return 0;
	}

	/**
	 * 更新用户信息，nickname和password
	 * 
	 * @param email
	 * @param password
	 * @param newUser
	 * @return 1,0
	 */
	public Integer updateNBUser(String email, String password, NBUser newUser) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbuser "
							+ "set nickname=? ,password=? where email=? and password=?");
			p.setString(1, newUser.getNickname());
			p.setString(2, newUser.getPassword());

			p.setString(3, email);
			p.setString(4, password);

			p.execute();
			logger.info("update user success " + newUser);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("update user failed" + newUser);
		}
		return 0;

	}

	/**
	 * 更新用户地址，由于之后有加主键，所以更新方式是提供userAddressID和新的address对象。
	 * 
	 * @param userAddressID
	 *            旧地址id
	 * @param newAddress
	 *            新地址
	 * @return 成功1，失败0
	 */
	public Integer updateNBUserAddress(int userAddressID,
			NBUserAddress newAddress) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbuseraddress "
							+ "set receiverName=?,address=?,postcode=?,telephone=?,mobilephone=? "
							+ " where useraddressID=?");
			p.setString(1, newAddress.getReceiverName());
			p.setString(2, newAddress.getAddress());
			p.setString(3, newAddress.getPostCode());
			p.setString(4, newAddress.getTelephone());
			p.setString(5, newAddress.getMobilePhone());
			p.setInt(6, userAddressID);
			p.execute();
			logger.info("update address success " + newAddress);
			return 1;
		} catch (SQLException e) {

			e.printStackTrace();
			logger.severe("update address failed" + newAddress);
		}
		return 0;
	}

	/**
	 * 更新用户地址，由于之前没有加主键，所以更新方式是提供旧的address对象和新的address对象。
	 * 
	 * @param oldaddress
	 *            旧地址
	 * @param newAddress
	 *            新地址
	 * @return 成功1，失败0
	 */
	public Integer updateNBUserAddress(NBUserAddress oldaddress,
			NBUserAddress newAddress) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbuseraddress "
							+ "set receiverName=?,address=?,postcode=?,telephone=?,mobilephone=? "
							+ " where useraddressID=?");
			p.setString(1, newAddress.getReceiverName());
			p.setString(2, newAddress.getAddress());
			p.setString(3, newAddress.getPostCode());
			p.setString(4, newAddress.getTelephone());
			p.setString(5, newAddress.getMobilePhone());
			p.setInt(6, oldaddress.getUserAddressID());
			p.execute();
			logger.info("update address success " + oldaddress + " new address"
					+ newAddress);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("update useraddress failed old address:" + oldaddress
					+ " new address" + newAddress);
		}
		return 0;
	}

	/**
	 * 更新白金卡什么玩意的最低积分等
	 * 
	 * @param categoryID
	 *            级别id
	 * @param newVipCategory
	 *            新级别
	 * @return 成功1 失败0
	 */
	public Integer updateNBVIPCategoryByID(Integer categoryID,
			NBVIPCategory newVipCategory) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbvipcategory set levelname=? ,leastscore=? ,scorepercentage=? where id=?");
			p.setString(1, newVipCategory.getLevelName());
			p.setInt(2, newVipCategory.getLeastScore());
			p.setDouble(3, newVipCategory.getScorePercentage());
			p.setInt(4, categoryID);

			p.execute();
			logger.info("update nbvipcategory success" + newVipCategory);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("nbvipcategory update失败" + newVipCategory);
		}
		return 0;
	}

	/**
	 * 更新白金卡什么玩意的最低积分等
	 * 
	 * @param categoryName
	 *            级别名称
	 * @param newVipCategory
	 *            新级别对象
	 * @return 成功1 失败0
	 */
	public Integer updateNBVIPCategoryByName(String categoryName,
			NBVIPCategory newVipCategory) {
		try {
			PreparedStatement p = connection
					.prepareStatement("update nbvipcategory set levelname=? ,leastscore=? ,scorepercentage=? where levelname=?");
			p.setString(1, newVipCategory.getLevelName());
			p.setInt(2, newVipCategory.getLeastScore());
			p.setDouble(3, newVipCategory.getScorePercentage());
			p.setString(4, categoryName);

			p.execute();
			logger.info("update nbvipcategory success" + newVipCategory);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("nbvipcategory update失败" + newVipCategory);
		}
		return 0;
	}

	/**
	 * 验证用户
	 * 
	 * @param email
	 *            用户email
	 * @param password
	 * @return 1成功 0失败
	 */
	public Integer validataUser(String email, String password) {
		PreparedStatement p;
		try {
			p = connection
					.prepareStatement("select * from nbuser where email=? and password=?");
			p.setString(1, email);
			p.setString(2, password);
			p.execute();
			logger.info("user " + email + " validated");
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("validate user failed" + email);
		}
		return 0;
	}

	/**
	 * 验证管理员
	 * 
	 * @author 赵国铨 2014年6月26日
	 * @param username
	 * @param password
	 * @return 返回经过验证的管理员对象
	 */
	public NBAdmin validateAdmin(String username, String password) {
		try {
			PreparedStatement p = connection
					.prepareStatement("select * from NBAdmin where username=? and password=?");
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				NBAdmin admin = new NBAdmin(rs.getString(1), rs.getString(2));
				logger.info("return admin");
				return admin;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.severe("get admin failed");
		return null;

	}
}
