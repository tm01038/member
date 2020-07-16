import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.member.lib.common.Connector;

public class TestUpdate {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		Map<String, Object> member = new HashMap<>();
		try {
			conn = Connector.open();
			String sql = " update member set ";
			Iterator<String> it = member.keySet().iterator();
			Map<String, Object> setColm = new LinkedHashMap<>();
			String whereNum = null;
			while (it.hasNext()) {
				String key = it.next();
				String value = member.get(key).toString();
				if (key.equals("m_num")) {
					whereNum = " where " + key + "= ? ";
					continue;
				}
				setColm.put(key, value);
			}
			int idxColm = 1;
			for (String keys : setColm.keySet()) {
				if (idxColm != setColm.size())
					sql += keys + "=? ,";
				sql += keys + "=? ";
				idxColm++;
			}
			sql += whereNum;
			ps = conn.prepareStatement(sql);
			idxColm = 1;
			for (String keys : setColm.keySet()) {
				ps.setString(idxColm, member.get(keys).toString());
				idxColm++;
			}

			result = ps.executeUpdate();
			conn.rollback();
			// " update member set m_name='정원돌' where m_num=3 ";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			Connector.close();
			ps = null;
			conn = null;
		}
	}

}
