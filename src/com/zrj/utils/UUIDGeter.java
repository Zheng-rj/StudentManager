package com.zrj.utils;

import java.util.UUID;

public class UUIDGeter {
	public static void main(String[] args) {
		for(int i=0;i<30;i++)
		new UUIDGeter().getUUID();
	}
	public String getUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(uuid);
		return uuid;
		
	}
}
