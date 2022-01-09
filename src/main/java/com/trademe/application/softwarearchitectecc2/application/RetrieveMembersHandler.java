package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.Contractor;
import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.Tradesman;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.QueryHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RetrieveMembersHandler implements QueryHandler<RetrieveMembers, List<Member>> {

    private final MemberRepository memberRepository;

    public RetrieveMembersHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> handle(RetrieveMembers query) {
        return memberRepository.All();
    }

    public List<Member> handleContractor(RetrieveMembers query) {
        List<Member> contractor = new ArrayList<>();
        for (Object member : Collections.unmodifiableList(memberRepository.All())) {
            if (member instanceof Contractor){
                contractor.add((Member) member);
            }
        }
        return contractor;
    }
    public List<Member> handleTradesman(RetrieveMembers query) {
        List<Member> tradesman = new ArrayList<>();
        for (Object member : Collections.unmodifiableList(memberRepository.All())) {
            if (member instanceof Tradesman){
                tradesman.add((Member) member);
            }
        }
        return tradesman;
    }
}
