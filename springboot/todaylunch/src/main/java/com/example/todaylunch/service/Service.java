package com.example.todaylunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.todaylunch.dto.Food;
import com.example.todaylunch.dto.Store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
	private static Service instance;
	private List<Food> foodList = new ArrayList<Food>();
	private List<Store> storeList = new ArrayList<Store>();

	
	
	private Service() {
		sampledate();
	}
	
	public static Service getinstance() {
		if(instance == null) {
			return new Service();
		}
		return instance;
	}
	
	public Food findFood(String foodName) {
		for (Food food : foodList) {
			if(food.getFoodName().equals(foodName)) {
				return food;
			}
		}
		return null;
		
		
	}
	
	public void sampledate() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(CategoryType.NOODLE.toString());
		list.add(CategoryType.SEASONFOOD.toString());
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(CategoryType.RICE.toString());
		list2.add(CategoryType.SOUP.toString());
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add(CategoryType.INSTANT.toString());
		
		ArrayList<Store> storeList = new ArrayList<Store>();
		storeList.add(new Store("부산밀면", "부산시 진구 부산밀면", 100));
		storeList.add(new Store("부산밀면2", "부산시 진구 부산밀면2", 120));
		
		ArrayList<Store> storeList2 = new ArrayList<Store>();
		storeList2.add(new Store("부산국밥", "부산시 진구 부산국밥", 200));
		storeList2.add(new Store("밀양국밥", "부산시 진구 밀양국밥", 180));
		
		ArrayList<Store> storeList3 = new ArrayList<Store>();
		storeList3.add(new Store("서브웨이", "부산시 진구 서브웨이", 220));
		storeList3.add(new Store("샌드위치샵", "부산시 진구 샌드위치샵", 180));
		
		Food food = new Food().builder().foodName("밀면").
				url("https://cdn.pixabay.com/photo/2018/09/17/05/14/water-noodle-3683050__340.jpg").
				category(list).
				storelist(storeList).
				build();
		
		Food food2 = new Food().builder().foodName("국밥").
				url("https://cdn.pixabay.com/photo/2019/07/07/10/40/for-money-4322226__340.jpg").
				category(list2).
				storelist(storeList2).
				build();
		
		Food food3 = new Food().builder().foodName("샌드위치").
				url("https://cdn.pixabay.com/photo/2017/03/10/13/49/fast-food-2132863__340.jpg").
				category(list3).
				storelist(storeList3).
				build();
		
		addFood(food);
		addFood(food2);
		addFood(food3);
		
	}
	
	public void addFood(Food food) {
		food.getStorelist().forEach(store -> {
			storeList.add(store);
		});
		foodList.add(food);
	}
	
	public void addStore(String foodName, Store store) {
		for (Food food : foodList) {
			if(food.getFoodName().equals(foodName)) {
				storeList.add(store);
				food.getStorelist().add(store);
				return;
			}
		}
	}

	public List<Store> getNearStorelist() {
		sortStore();
		for (Store store : storeList) {
			System.out.println(store.toString());
		}
		return storeList;
		
	}
	
	private void sortStore(){
		Collections.sort(storeList, new Comparator<Store>() {
			@Override
			public int compare(Store o1, Store o2) {
				int result = -1;
				if(o1.getDistance() >= o2.getDistance()) {
					result = 1;
				}
				return result;
			}
		});
	}
	
	public List
	
	
	
	
	
	
	
	
	
	

}
