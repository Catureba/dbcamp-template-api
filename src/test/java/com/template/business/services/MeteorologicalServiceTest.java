package com.template.business.services;

import com.template.data.entity.MeteorologicalEntity;
import com.template.data.repository.MeteorologicalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class MeteorologicalServiceTest {


    @Mock
    private MeteorologicalRepository meteorologicalRepository;
    @InjectMocks
    private MeteorologicalService meteorologicalService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test do GET findAll/ Deve checar se o retorno do metodo findAll() é igual a quantidade de dados mockados")
    void testFindAll() {
        List<MeteorologicalEntity> meteorologicalEntities = new ArrayList<>();
        meteorologicalEntities.add(new MeteorologicalEntity());
        meteorologicalEntities.add(new MeteorologicalEntity());

        when(meteorologicalRepository.findAll()).thenReturn(meteorologicalEntities);
        List<MeteorologicalEntity> result = meteorologicalService.findAll();
        verify(meteorologicalRepository).findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test do GET findByCity/ Deve checar se o retorno do metodo findByCity() é igual a quantidade de dados mockados")
    void testFindByCity() {
        String city = "madre de deus";
        String anotherCity = "madre de deus";

        List<MeteorologicalEntity> meteorologicalEntities = new ArrayList<>();

        meteorologicalEntities.add(new MeteorologicalEntity(anotherCity));
        meteorologicalEntities.add(new MeteorologicalEntity(city));

        when(meteorologicalRepository.findByCity(city)).thenReturn(meteorologicalEntities);
        List<MeteorologicalEntity> result = meteorologicalService.findByCity(city);
        verify(meteorologicalRepository).findByCity(city);

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test do POST create/ Deve checar se o retorno do metodo create() é igual ao POST feito")
    void testCreate() {
        MeteorologicalEntity meteorologicalEntity = new MeteorologicalEntity();

        when(meteorologicalRepository.save(any(MeteorologicalEntity.class))).thenReturn(meteorologicalEntity);
        MeteorologicalEntity result = meteorologicalService.create(meteorologicalEntity);
        verify(meteorologicalRepository).save(meteorologicalEntity);

        assertNotNull(result);
        assertEquals(meteorologicalEntity, result);
    }

}
