//package test;
//
//import com.sp.model.ConnDBMySql;
//import com.sp.model.GoodsDAO;
//import com.sp.model.GoodsDAOImpl;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class TestDB {
//
//	@Test
//	public void testDBConnection() {               //测试数据库是否连接成功
//		ConnDBMySql con = new ConnDBMySql();
//		assertNotNull(con.getConn());
//	}
//
//	@Test
//	public void testQueryAll() {                    //测试是否能查询所有用户
//		GoodsDAO  d= new GoodsDAOImpl();
//		assertEquals(d.getGoods().size(), 4);
//	}
//
//	@Test
//	public void testInsertUser() {
//		// TODO 测试用户是否正确插入
//	}
//}
