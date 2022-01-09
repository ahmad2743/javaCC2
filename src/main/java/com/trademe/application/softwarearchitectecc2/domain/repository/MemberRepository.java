package com.trademe.application.softwarearchitectecc2.domain.repository;


import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.kernel.NoSuchEntityException;

import java.util.List;

public interface MemberRepository<VOID, E> {
        List<E> All();
        E findById(VOID id) throws NoSuchEntityException;
        void add(E entity);
        void delete(VOID id);

        VOID nextIdentity();

}
