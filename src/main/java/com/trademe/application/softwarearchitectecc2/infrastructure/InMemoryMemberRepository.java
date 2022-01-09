package com.trademe.application.softwarearchitectecc2.infrastructure;

import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.model.Tradesman;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMemberRepository implements MemberRepository<MemberId, Member> {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public List<Member> All() {
        return List.copyOf(data.values());
    }

    @Override
    public Member findById(MemberId id) throws NoSuchEntityException {
        final Member member = data.get(id);
        if (member == null) {
            throw NoSuchEntityException.withId(id);
        }
        return member;    }

    @Override
    public void add(Member member) {
        data.put(member.getId(), member);
    }

    @Override
    public void delete(MemberId id) {
        data.remove(id);
    }

    @Override
    public MemberId nextIdentity() {
        return new MemberId(count.incrementAndGet());
    }
}
