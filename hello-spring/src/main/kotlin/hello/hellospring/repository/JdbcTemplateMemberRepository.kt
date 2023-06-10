package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.springframework.jdbc.core.JdbcTemplate

class JdbcTemplateMemberRepository(
    private final val jdbcTemplate: JdbcTemplate
): MemberRepository {

    override fun save(member: Member): Member {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Member? {
        return jdbcTemplate.query("select * from member where id = ?", )

    }

    override fun findByName(name: String): Member? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Member> {
        TODO("Not yet implemented")
    }
}