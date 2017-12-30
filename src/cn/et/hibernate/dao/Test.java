package cn.et.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import cn.et.hibernate.HibernateSessionFactory;

public class Test {
	public static void main(String[] args) {
		queryFood();
	}
	public static void saveFood() {
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodname("Ïã½¶Åª¸ö°ÍÀ­");
		food.setImagepath("/a");
		session.getTransaction().begin();
		session.save(food);
		session.getTransaction().commit();
	}
	public static void deleteFood() {
		Session session = HibernateSessionFactory.getSession();
		Food food = new Food();
		food.setFoodid(12);
		session.getTransaction().begin();
		session.delete(food);
		session.getTransaction().commit();
	}
	
	public static void queryFood(){
		Session session=HibernateSessionFactory.getSession();
		Food food=(Food)session.load(Food.class,13);
		System.out.println(food.getFoodname());
		// hsqlÕZÑÔ
		
		
		
		Query query=session.createQuery("from Food where foodName like :aaaaaa ");
		query.setString("aaaaaa", "%Çà%");
		List<Food> foodList=query.list();
		System.out.println(foodList.size());
	}
}
