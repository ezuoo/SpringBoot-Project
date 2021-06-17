package iducs.springboot.a201712007.mapper;

import iducs.springboot.a201712007.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public int getMembers();
}
