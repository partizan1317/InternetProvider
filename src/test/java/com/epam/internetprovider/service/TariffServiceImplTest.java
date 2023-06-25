package com.epam.internetprovider.service;

import com.epam.internetprovider.connection.ConnectionPool;
import com.epam.internetprovider.dao.DaoHelper;
import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.entity.Tariff;
import com.epam.internetprovider.service.TariffServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TariffServiceImplTest {

//    private final DaoHelper daoHelper = new DaoHelper(ConnectionPool.getInstance());
//    private final String startDateLine = "2022-03-12";
//    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    private final Date startDate = formatter.parse(startDateLine);
//    private final Optional<Tariff> expectedTariff = Optional.of(new Tariff(1L,"Smart", startDate,null,true, true, new BigDecimal("1000.00")));
//    private final Optional<Tariff> expectedEmptyTariff = Optional.empty();
//    private final List<Tariff> expectedTariffs = Arrays.asList(
//            new Tariff(1L,"Smart", startDate,null,true, true, new BigDecimal("1000.00")),
//            new Tariff(2L,"Flash", startDate,null,true, false, new BigDecimal("2000.00")),
//            new Tariff(3L,"Advance", startDate,null,true, false, new BigDecimal("3000.00"))
//    );
//    private final Long correctId = 1L;
//    private final Long inCorrectId = 100L;
//
//    public TariffServiceImplTest() throws ParseException {
//    }
//
//    @Test
//    public void testGetByIdShouldReturnTariffIfIdIsCorrect() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        TariffServiceImpl service = new TariffServiceImpl(daoHelperFactory);
//        Optional<Tariff> actualTariff = service.getById(correctId);
//        Assert.assertEquals(expectedTariff, actualTariff);
//    }
//
//    @Test
//    public void testGetByIdShouldReturnAnEmptyContainerIfIdIsIncorrect() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        TariffServiceImpl service = new TariffServiceImpl(daoHelperFactory);
//        Optional<Tariff> actualTariff = service.getById(inCorrectId);
//        Assert.assertEquals(expectedEmptyTariff, actualTariff);
//    }
//
//    @Test
//    public void testGetAllShouldReturnAllTariffsFromDatabase() throws Exception {
//        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
//        Mockito.when(daoHelperFactory.create()).thenReturn(daoHelper);
//        TariffServiceImpl service = new TariffServiceImpl(daoHelperFactory);
//        List<Tariff> actualTariffs = service.getAll();
//        Assert.assertEquals(expectedTariffs, actualTariffs);
//    }
}
