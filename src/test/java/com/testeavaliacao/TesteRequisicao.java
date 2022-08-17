package com.testeavaliacao;

import com.testeavaliacao.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteRequisicao {
    @Test
    void testeRequisicao() {
        String json = TestService.requisition();
        Assertions.assertNotNull(json);
    }
}
