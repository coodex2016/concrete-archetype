package org.coodex.example;

import org.coodex.concrete.api.AccessAllow;
import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.api.MicroService;
import org.coodex.concrete.api.mockers.VehicleNum;
import org.coodex.concrete.api.pojo.StrID;
import org.coodex.util.Parameter;

@MicroService("example")
public interface ExampleApi extends ConcreteService {

    @Description(name = "求和")
    int add(
            @Parameter("x1") @Description(name = "被加数") int x1,
            @Parameter("x2") @Description(name = "加数") int x2);

    @MicroService("vehicles")//定义资源名，详见restful风格
    /**
     * 针对jax-rs提供服务时，concrete有一套谓词管理，
     * 可以通过predicate.properties进行重载，
     * 详见 {@link https://concrete.coodex.org/%E5%B7%A5%E5%85%B7%E9%93%BE/jsr311.html#谓词定义 }
     */
    @VehicleNum
    String getRandomVeh(
            @Parameter("id") String id);


    /**
     * rbac，声明该服务必须已登录用户才可访问
     * <p>
     * 详见 {@link https://concrete.coodex.org/%E5%AE%9A%E4%B9%89/AccessAllow.html }
     */
    @AccessAllow
    String aclTest();

    @MicroService("vehicles")
    // post method
    StrID<VehicleInfo> saveVehicle(@Parameter("info")VehicleInfo info);

    @MicroService("vehicles")
    // delete method
    void delete(@Parameter("vehId") String vehId);

    @MicroService("vehicles")
    // put method
    StrID<VehicleInfo> updateVehicle(@Parameter("id") String id, @Parameter("info")VehicleInfo info);

}
