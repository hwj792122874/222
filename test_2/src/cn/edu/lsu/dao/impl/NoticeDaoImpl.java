package cn.edu.lsu.dao.impl;

import cn.edu.lsu.bean.Notice;
import cn.edu.lsu.bean.Products;
import cn.edu.lsu.bean.User;
import cn.edu.lsu.dao.NoticeDAO;
import cn.edu.lsu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class NoticeDaoImpl implements NoticeDAO {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Notice> getAllNotices() {
        String sql="select * from notice";
        List<Notice> notices = template.query(sql, new BeanPropertyRowMapper<Notice>(Notice.class));
        return notices;

    }

    @Override
    public int addNotice(Notice n) {
        String sql="insert into notice(title,details,n_time) values(?,?,?)";
        template.update(sql,n.getTitle(),n.getDetails(),n.getN_time());
        return 0;
    }

    @Override
    public Notice findNoticeById(String n_id) {
        String sql="select *from notice where n_id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Notice>(Notice.class),n_id);

    }

    @Override
    public int updateNotice(Notice n) {
        String sql="update notice set title=?,details=?,n_time=? where n_id=?";
        template.update(sql,n.getTitle(),n.getDetails(),n.getN_time(),n.getN_id());
        return 0;
    }

    @Override
    public int deleteNotice(String n_id) {
        String sql="delete from notice where n_id=?";
        template.update(sql,n_id);
        return 0;
    }

    @Override
    public Notice getRecentNotice() {
        return null;
    }
}
