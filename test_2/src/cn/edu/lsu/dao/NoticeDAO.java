package cn.edu.lsu.dao;

import java.util.List;

import cn.edu.lsu.bean.Notice;




public interface NoticeDAO {
	//查询所有公告
		public List<Notice> getAllNotices();
		//添加公告
		public int addNotice(Notice n);
		//按ID查询公告
		public Notice findNoticeById(String n_id);
		//更新公告
		public int updateNotice(Notice n);
		//删除公告
		public int deleteNotice(String n_id);
		//查询最新公告
		public Notice getRecentNotice();
}
