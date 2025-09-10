package com.service.reviewsService.review.infrastructure.outputadapter.feing;

import com.service.reviewsService.common.infrastructure.exception.ExternalServiceException;
import com.service.reviewsService.review.application.ports.output.FindingAllCustomersOutputPort;
import com.service.reviewsService.review.domain.CustomerDomainEntity;
import com.service.reviewsService.review.infrastructure.outputadapter.feing.mapper.CustomerFeignMapperRest;
import com.service.reviewsService.review.infrastructure.outputadapter.feing.rest.AuthIdentityRestClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerFeignOutputAdapter implements FindingAllCustomersOutputPort {

    private final AuthIdentityRestClient authIdentityRestClient;
    private final CustomerFeignMapperRest mapper;

    @Override
    public List<CustomerDomainEntity> findAllCustomers() {
        try {
            return authIdentityRestClient.findAllCustomers().stream()
                    .map(mapper::toDomainEntity)
                    .toList();

        } catch (FeignException e) {
            throw new ExternalServiceException("No se pudieron obtener los clientes en el servico.");
        }
    }
}
