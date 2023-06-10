package hello.hellospring.service

import hello.hellospring.domain.Member
import hello.hellospring.repository.MemberRepository
import hello.hellospring.repository.MemoryMemberRepository

class MemberService(
    private val memberRepository: MemberRepository
) {
    /*
    * 회원 가입
    * */
    fun join(member: Member): Long {
        validateDuplicateMember(member)

        memberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        val result = memberRepository.findByName(member.name)
        result?.let {
            throw IllegalStateException("이미 존재하는 회원: ${it}")
        }
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}