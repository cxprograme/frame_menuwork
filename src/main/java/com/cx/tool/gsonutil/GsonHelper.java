package com.cx.tool.gsonutil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @Description: gson数据类型
 * @author fangqh07068
 * @date 2012-11-21 下午3:41:19
 */
public class GsonHelper {
	
	//gson实例
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create() ;

	//String 转 Object
	 public static Type msmss = new TypeToken<Map<String,Map<String,String>>>() {}.getType();
	 public static Map<String,Map<String,String>>  msmss(String str){
		 return  gson.fromJson(str, msmss);
	 }
	 
	 public static Type msmso = new TypeToken<Map<String,Map<String,Object>>>() {}.getType();
	 public static Map<String,Map<String,Object>>  msmso(String str){
		 return  gson.fromJson(str, msmso);
	 }
	
	 public static Type mss = new TypeToken<Map<String,String>>() {}.getType();
	 public static Map<String,String>  mss(String str){
		 return  gson.fromJson(str, mss);
	 }
	 
	 public static Type mso = new TypeToken<Map<String,Object>>() {}.getType();
	 public static Map<String,Object>  mso(String str){
		 return  gson.fromJson(str, mso);
	 }
	 
	 public static Type lmss = new TypeToken<List<Map<String,String>>>() {}.getType();
	 public static List<Map<String,String>>  lmss(String str){
		 return  gson.fromJson(str, lmss);
	 }
	 
	 public static Type lmso = new TypeToken<List<Map<String,Object>>>() {}.getType();
	 public static List<Map<String,Object>>  lmso(String str){
		 return  gson.fromJson(str, lmso);
	 }
	 
	 public static Type mslo = new TypeToken<Map<String,ArrayList<Object>>>() {}.getType();
	 public static Map<String,List<Object>>  mslo(String str){
		 return  gson.fromJson(str, mslo);
	 }
	 
	 public static Type msls = new TypeToken<Map<String,ArrayList<String>>>() {}.getType();
	 public static Map<String,List<String>>  msls(String str){
		 return  gson.fromJson(str, msls);
	 }
	 
	 public static Type ls = new TypeToken<List<String>>() {}.getType();
	 public static List<String>  ls(String str){
		 return  gson.fromJson(str, ls);
	 }
	 
	 public static Type lo = new TypeToken<List<Object>>() {}.getType();
	 public static List<Object>  lo(String str){
		 return  gson.fromJson(str, lo);
	 }
	 
	 public static Type ss = new TypeToken<Set<String>>() {}.getType();
	 public static Set<String>  ss(String str){
		 return  gson.fromJson(str, ss);
	 }
	 
	 public static Type so = new TypeToken<Set<Object>>() {}.getType();
	 public static Set<Object>  so(String str){
		 return  gson.fromJson(str, so);
	 }
	 
	 //传入类型转换
	 @SuppressWarnings("unchecked")
	 public static <T> T  fromJson(String str,Type typeOfT){
		    T target = (T) gson.fromJson(str, typeOfT);
		    return target;
	 }
	 
	 //Object 转 String
	 public static String  toJson(Object obj){
		 return  gson.toJson(obj);
	 } 

}
