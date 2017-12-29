package org.coodex.example;

import org.coodex.concrete.common.Assert;
import org.coodex.example.entities.AddId;
import org.coodex.example.repos.AddEntityRepo;

import javax.inject.Inject;

public class ExampleImpl implements ExampleApi {

    @Inject
    private AddEntityRepo addEntityRepo;

    @Override
    public int add(int x1, int x2) {
        return Assert.isNull(
                addEntityRepo.findOne(new AddId(x1, x2)),
                ExampleErrorCodes.TOO_HARD, x1, x2).getSum();
    }

    @Override
    public String getRandomVeh(String id) {
        return "不要打了，我就是车牌，行了吧？";
    }

    @Override
    public String aclTest() {
        return null;
    }
}
