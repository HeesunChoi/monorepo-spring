package hello.hellospring.repository

import hello.hellospring.domain.Member

class MemoryMemberRepository:  MemberRepository {

    val store: HashMap<Long, Member> = hashMapOf()
    val sequence: Long = 0L

    override fun save(member: Member): Member {
        member.id = sequence + 1
        store.put(member.id, member)
        return member
    }

    override fun findById(id: Long): Member? {
        return store.get(id)
    }

    override fun findByName(name: String): Member? {
        return store.values.filter { member ->
            member.name.equals(name)
        }.first()
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

}