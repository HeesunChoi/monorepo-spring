package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {
    private val repository: MemoryMemberRepository = TODO()

    @AfterEach
    fun afterEach() {

    }

    @Test
    fun save() {
        val member: Member = Member(1, "test")
        member.name = "spring"

        repository.save(member)

        val result = repository.findById(member.id)
        Assertions.assertEquals(member, result)
    }
}