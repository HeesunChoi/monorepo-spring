package hello.hellospring.repository

import hello.hellospring.domain.Member
import java.sql.Connection
import java.sql.PreparedStatement
import javax.sql.DataSource

class JdbcMemberRepository(
    private val dataSource: DataSource
) :  MemberRepository{
    override fun save(member: Member): Member {
        val sql: String = "insert into member(name) values(?)"
        val conn: Connection = dataSource.getConnection()
        val pstmt: PreparedStatement = conn.prepareStatement(sql)
        pstmt.setString(1, member.name)
        pstmt.executeUpdate()

    }
    override fun findById(id: Long): Member? {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Member? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Member> {
        TODO("Not yet implemented")
    }
}