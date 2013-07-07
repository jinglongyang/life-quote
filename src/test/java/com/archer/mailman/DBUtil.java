package com.archer.mailman;
//package com.archer.mailman.dao;
//
//import java.io.IOException;
//import java.net.UnknownHostException;
//
//import net.vz.mongodb.jackson.JacksonDBCollection;
//import net.vz.mongodb.jackson.WriteResult;
//
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.JsonParseException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import com.archer.mailman.common.util.CommonUtil;
//import com.archer.mailman.db.domain.UserEntity;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.MongoClient;
//import com.mongodb.util.JSON;
//
//
////http://www.mkyong.com/mongodb/java-mongodb-query-document/
//
//public class DBUtil {
//
//	private static MongoClient mongoClient;
//	private static DB db;
//	private static DBCollection collection;
//	private static ObjectMapper mapper = new ObjectMapper();
//
//	public static void getConnection() throws UnknownHostException {
//		mongoClient = new MongoClient("localhost", 27017);
//		db = mongoClient.getDB("cedar");
//		collection = db.getCollection("user");
//
//	}
//
//	//this is manual mapping...
//	public static void insertDB() throws JsonGenerationException,
//			JsonMappingException, IOException {
//		UserEntity ue = new UserEntity();
//		ue.setEmail("whatever@gmail.com");
//		ue.setGuid(CommonUtil.generateUid());
//		String json = mapper.writeValueAsString(ue);
//		DBObject dbObject = (DBObject) JSON.parse(json);
//		collection.insert(dbObject);
//	}
//
//	//this is using jackson-mongo mapper...
//	public static void insertDB2() throws JsonGenerationException,
//			JsonMappingException, IOException {
//		UserEntity ue = new UserEntity();
//		ue.setEmail("whatever123123@gmail.com");
//		ue.setGuid(CommonUtil.generateUid());
//
//		JacksonDBCollection<UserEntity, String> coll = JacksonDBCollection
//				.wrap(collection, UserEntity.class, String.class);
//
//		WriteResult<UserEntity, String> result = coll.insert(ue);
//	}
//
//	public static void updateDB() throws JsonGenerationException,
//			JsonMappingException, IOException {
//		UserEntity ue = new UserEntity();
//		ue.setEmail("whatever1@gmail.com");
//		ue.setCell("123123");
//		String json = mapper.writeValueAsString(ue);
//		DBObject newDocument = (DBObject) JSON.parse(json);
//		BasicDBObject searchQuery = new BasicDBObject().append("email",
//				"whatever@gmail.com");
//
//		collection.update(searchQuery, newDocument);
//	}
//
//	public static void getDB() throws JsonParseException, JsonMappingException,
//			IOException {
//
//		BasicDBObject whereQuery = new BasicDBObject();
//		whereQuery.put("email", "whatever@gmail.com");
//		DBCursor cursor = collection.find(whereQuery);
//		while (cursor.hasNext()) {
//			UserEntity ue = mapper.readValue(cursor.next().toString(),
//					UserEntity.class);
//			System.out.println(ue.toString());
//		}
//	}
//	
//
//	
//	
//	
//	
//
//	public static void delete() {
//
//		collection.remove(new BasicDBObject().append("email",
//				"whatever1@gmail.com"));
//
//	}
//
//	public static void closeConnection() throws UnknownHostException {
//		mongoClient.close();
//
//	}
//
//}
