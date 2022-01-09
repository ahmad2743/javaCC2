package com.trademe.application.softwarearchitectecc2;

import com.trademe.application.softwarearchitectecc2.application.*;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.infrastructure.InMemoryMemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.Event;
import com.trademe.application.softwarearchitectecc2.kernel.EventBus;
import com.trademe.application.softwarearchitectecc2.kernel.EventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfiguration {
    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public EventBus<Event> eventBus() {
        EventBus eventBus = new DefaultEventBus();
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        eventBus.register(BillPaymentEvent.class, List.of(new BillPaymentMonthlyEventListener(memberRepository())));
        eventBus.register(CreateMemberEvent.class, List.of(new CreateMemberEventListener(memberRepository())));
        return eventBus;
    }

    @Bean
    public CreateTradesmanCommandHandler createTradesmanCommandHandler() {
        return new CreateTradesmanCommandHandler(memberRepository(), eventBus());
    }

    @Bean
    public CreateContractorCommandHandler createContractorCommandHandler() {
        return new CreateContractorCommandHandler(memberRepository(), eventBus());
    }

    @Bean
    public RetrieveMembersHandler retrieveMembersHandler() {
        return new RetrieveMembersHandler(memberRepository());
    }

    @Bean
    public RetrieveMemberByIdHandler retrieveMemberByIdHandler() {
        return new RetrieveMemberByIdHandler(memberRepository());
    }
    @Bean
    public CreateMemberEventListener createMemberEventListener(){
        return new CreateMemberEventListener(memberRepository());
    }
    @Bean
    public  BillPaymentMonthlyEventListener billPaymentMonthlyEventListener() {
        return new BillPaymentMonthlyEventListener(memberRepository());}
    }
