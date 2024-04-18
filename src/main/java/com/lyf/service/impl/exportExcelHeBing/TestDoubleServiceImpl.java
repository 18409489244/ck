package com.lyf.service.impl.exportExcelHeBing;
import com.lyf.entity.exportExcelHeBing.TestDouble;
import com.lyf.mapper.exportExcelHeBing.TestDoubleMapper;
import com.lyf.service.exportExcelHeBing.TestDoubleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @program: codepractice
 * @description:
 * @create: 2024-04-17 15:06
 **/
@Service
public class TestDoubleServiceImpl implements TestDoubleService {
    @Autowired
    private TestDoubleMapper testDoubleMapper;

    @Override
    public List<TestDouble> testDouble() {
        List<TestDouble> testDoubles = testDoubleMapper.selectData();
        return testDoubles;
    }
}
