package io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;

public class AddressTest {

	public static void getInsertSql(String[] keys, List<Map<String, String>> list) {

		String sql = " insert into address( ";
		String value = " values(";
		for (String key : keys) {
			sql += key + ",";
			value += "?,";
		}

		try {
			sql = sql.substring(0, sql.length() - 1) + ")\r\n";
			value = value.substring(0, value.length() - 1) + ")";
			sql += value;
			Connection con = Connector.open();
			PreparedStatement ps = con.prepareStatement(sql);
			for (Map<String, String> row : list) {
				for (int i = 0; i < keys.length; i++) {
					ps.setString((i + 1), row.get(keys[i]));
				}
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String key = ReadText.readTest("C:\\java_jeong\\address\\build_sejong.txt");
		String keyStr = "DONG_CODE\r\n" + "SIDO\r\n" + "GUGUN\r\n" + "DONG_NAME\r\n" + "LEE_NAME\r\n" + "IS_MNT\r\n"
				+ "JIBUN\r\n" + "SUB_JIBUN\r\n" + "ROAD_CODE\r\n" + "ROAD_NAME\r\n" + "IS_BASE\r\n" + "BUILD_NUM\r\n"
				+ "SUB_BUILD_NUM\r\n" + "BUILDING_NAME\r\n" + "DETAIL_BUILDING_NAME\r\n" + "ADDR_CODE";

		String[] strs = key.split("\r\n");
		String[] keys = null;
		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (i == 0) {
				keys = keyStr.split("\r\n");
			} else {
				String[] values = strs[i].split("\\|");
				Map<String, String> map = new LinkedHashMap<>();
				for (int idx = 0; idx < keys.length; idx++) {
					map.put(keys[idx], values[idx]);
				}
				list.add(map);
			}
		}
		getInsertSql(keys,list);
		
	}
}
