package com.trademe.application.softwarearchitectecc2;

import com.trademe.application.softwarearchitectecc2.application.*;
import com.trademe.application.softwarearchitectecc2.domain.model.*;
import com.trademe.application.softwarearchitectecc2.kernel.Event;
import com.trademe.application.softwarearchitectecc2.kernel.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Timer;

@SpringBootApplication
public class SoftwareArchitecteCc2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SoftwareArchitecteCc2Application.class, args);

        // 1. Create Contractor
        CreateContractorCommandHandler contractorCommandHandler = applicationContext.getBean(CreateContractorCommandHandler.class);
        CreateMember createContractor = new CreateMember("Jean", "Marteau",
                new MemberInformation("jean@gmail.com", "passer", "0645342343",
                        new Address(12, "Macron", "Paris", "75011", "app 1804")));
        CreditCard card = new CreditCard("Jean Marteau", "5464123454321234", "03/2024", 111);
        createContractor.setCreditCard(card);
        final MemberId contractorId = contractorCommandHandler.handle(createContractor);

        // 1. Create Tradesman
        CreateTradesmanCommandHandler tradesmanCommandHandler = applicationContext.getBean(CreateTradesmanCommandHandler.class);
        CreateMember createTradesman = new CreateMember("Roman", "Frayssinet",
                new MemberInformation("Roman@gmail.com", "passer", "0845342343",
                        new Address(5, "Avenue des nulls", "Paris", "75019", "app 114")));
        CreditCard card1 = new CreditCard("Roman Frayssinet", "1111222233334444", "03/2025", 345);
        createTradesman.setCreditCard(card1);
        final MemberId tradesmanId = tradesmanCommandHandler.handle(createTradesman);

        // 3. Retrieve all members
        RetrieveMembers retrieveMembers = new RetrieveMembers();
        RetrieveMembersHandler retrieveMembersHandler = applicationContext.getBean(RetrieveMembersHandler.class);
        final List<Member> members = retrieveMembersHandler.handle(retrieveMembers);
        members.forEach(System.out::println);

        // 4. Retrieve member by id
        RetrieveMemberById retrieveMemberById = new RetrieveMemberById(tradesmanId.getValue());
        RetrieveMemberByIdHandler retrieveMemberByIdHandler = applicationContext.getBean(RetrieveMemberByIdHandler.class);
        final Member member = retrieveMemberByIdHandler.handle(retrieveMemberById);
        System.out.println(member);

        // 5. set monthly payment for all users
        EventBus eventBus = applicationContext.getBean(EventBus.class);
        int the1st = new Date().getDay();
        int at16hrs = new Date().getHours();

        MonthlyTimer monthlyTimer = MonthlyTimer.schedule(() -> eventBus.publish(new BillPaymentEvent()), the1st, at16hrs );
        monthlyTimer.cancelCurrent();

    }
}

