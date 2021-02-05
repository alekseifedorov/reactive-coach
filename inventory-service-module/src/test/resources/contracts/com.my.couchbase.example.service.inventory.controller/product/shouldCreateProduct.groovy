package contracts.com.my.couchbase.example.service.inventory.controller.product

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description 'should create product'
    request {
        method POST()
        headers {
            contentType(applicationJson())
            acceptCharset()
        }
        body(
                "id": "123eff67-e89b-12d3-a456-426655440001",
                "name": "product1",
                "description": "description1",
                "quantity": 1
        )
        url('/api/v1/product')
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file('responses/responseMessages.json'))
    }
}
