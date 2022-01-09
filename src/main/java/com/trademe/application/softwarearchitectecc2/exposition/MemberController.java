package com.trademe.application.softwarearchitectecc2.exposition;

import com.trademe.application.softwarearchitectecc2.application.*;
import com.trademe.application.softwarearchitectecc2.domain.model.Address;
import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final CreateTradesmanCommandHandler createTradesmanCommandHandler;
    private final CreateContractorCommandHandler createContractorCommandHandler;
    private final RetrieveMemberByIdHandler retrieveMemberByIdHandler;
    private final RetrieveMembersHandler retrieveMembersHandler;

    @Autowired
    private MemberController(CreateTradesmanCommandHandler createTradesmanCommandHandler, CreateContractorCommandHandler createContractorCommandHandler, RetrieveMemberByIdHandler retrieveMemberByIdHandler, RetrieveMembersHandler retrieveMembersHandler) {
        this.createTradesmanCommandHandler = createTradesmanCommandHandler;
        this.createContractorCommandHandler = createContractorCommandHandler;
        this.retrieveMemberByIdHandler = retrieveMemberByIdHandler;
        this.retrieveMembersHandler = retrieveMembersHandler;
    }

    @PostMapping(path = "/tradesman", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> createTradesman(@RequestBody MemberRequest request) {
        CreateMember createMember = new CreateMember(request.firstName, request.lastName,
                new MemberInformation(request.information.email, request.information.password,
                        request.information.callNumber, Address.of(request.information.address.streetNumber,
                        request.information.address.streetName, request.information.address.city, request.information.address.zipCode,
                        request.information.address.additionalAddress)));
        createTradesmanCommandHandler.handle(createMember);
        return ResponseEntity.ok(null);
    }

    @PostMapping(path = "/contractor", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> createContractor(@RequestBody MemberRequest request) {
        CreateMember createMember = new CreateMember(request.firstName, request.lastName,
                new MemberInformation(request.information.email, request.information.password,
                        request.information.callNumber, Address.of(request.information.address.streetNumber,
                        request.information.address.streetName, request.information.address.city, request.information.address.zipCode,
                        request.information.address.additionalAddress)));
        createContractorCommandHandler.handle(createMember);
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/member/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Member> getMemberById(@PathVariable("id") final int id) {
        return ResponseEntity.ok(retrieveMemberByIdHandler.handle(new RetrieveMemberById(id)));
    }

    @GetMapping(path = "/members", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Member>> getMembers() {
        return ResponseEntity.ok(retrieveMembersHandler.handle(new RetrieveMembers()));
    }

    @GetMapping(path = "/tradesmans", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Member>> getTradesmans() {
        return ResponseEntity.ok(retrieveMembersHandler.handleTradesman(new RetrieveMembers()));
    }

    @GetMapping(path = "/contractors", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Member>> getContractos() {
        return ResponseEntity.ok(retrieveMembersHandler.handleContractor(new RetrieveMembers()));
    }

}
