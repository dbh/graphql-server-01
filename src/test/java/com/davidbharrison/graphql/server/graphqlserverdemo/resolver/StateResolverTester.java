package com.davidbharrison.graphql.server.graphqlserverdemo.resolver;

import com.davidbharrison.graphql.server.graphqlserverdemo.repo.StateRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class StateResolverTester {
    @MockBean
    StateRepo stateRepo;

    StateResolver cut;

    @BeforeEach
    public void setupEach() {
        cut = new StateResolver(stateRepo);
    }

    @Test
    public void testDeleteWhenNotFound() {
        Boolean result = cut.deleteState(1);
        Assertions.assertFalse(result);
    }

    @Test
    public void testDeleteWhenFound() {
        Mockito.when(stateRepo.existsById(1)).thenReturn(true);
        Boolean result = cut.deleteState(1);
        Assertions.assertTrue(result);
    }


}
