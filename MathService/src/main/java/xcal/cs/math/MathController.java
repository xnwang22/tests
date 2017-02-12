package xcal.cs.math;

import com.google.common.collect.Sets;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import xcal.cs.math.model.*;

@RestController
public class MathController {

    private static final Logger LOG = LoggerFactory.getLogger(MathController.class);

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public AdditionResponse add(@RequestBody @Valid AdditionRequest request) {
        int sum = ArithmeticUtils.addAndCheck(request.getAugend(), request.getAddend());
        LOG.info("{} + {} = {}", request.getAugend(), request.getAddend(), sum);
        return new AdditionResponse(sum);
    }

    @RequestMapping(path = "/divide", method = RequestMethod.POST)
    public DivisionResponse divide(@RequestBody @Valid DivisionRequest request) {
        int quotient = request.getDividend() / request.getDivisor();
        int remainder = request.getDividend() - quotient * request.getDivisor();
        LOG.info("{} / {} = {}, with remainder {}", request.getDividend(), request.getDivisor(), quotient, remainder);
        return new DivisionResponse(quotient, remainder);
    }

    @RequestMapping(path = "/intersect", method = RequestMethod.POST)
    public IntersectResponse intersect(@RequestBody @Valid final IntersectRequest request) {
//        List<Integer> intersect = request.getLeft().stream().filter(s -> request.getRight().contains(s)).collect(Collectors.toList());
        Set intersect = Sets.intersection(new HashSet(request.getLeft()), new HashSet<>(request.getRight()));
        LOG.info("INTERSECT({}, {}) = {}", request.getLeft(), request.getRight(), intersect);
        return new IntersectResponse(intersect);
    }

    @RequestMapping(path = "/max", method = RequestMethod.POST)
    public MaxResponse max(@RequestBody @Valid MaxRequest request) {
        Integer max = null;
        for (Integer i : request.getNumbers()) {
            if (max == null || i > max) {
                max = i;
            }
        }
        LOG.info("MAX({}) = {}", request.getNumbers(), max);
        return new MaxResponse(max);
    }

    @RequestMapping(path = "/min", method = RequestMethod.POST)
    public MinResponse min(@RequestBody @Valid MinRequest request) {
        Integer min = null;
        for (Integer i : request.getNumbers()) {
            if (min == null || i < min) {
                min = i;
            }
        }
        LOG.info("MIN({}) = {}", request.getNumbers(), min);
        return new MinResponse(min);
    }

    @RequestMapping(path = "/multiply", method = RequestMethod.POST)
    public MultiplicationResponse multiply(@RequestBody @Valid MultiplicationRequest request) {
        Integer product = ArithmeticUtils.mulAndCheck(request.getMultiplicand(), request.getMultiplier());
        LOG.info("{} * {} = {}", request.getMultiplicand(), request.getMultiplier(), product);
        return new MultiplicationResponse(product);
    }

    @RequestMapping(path = "/union", method = RequestMethod.POST)
    public UnionResponse union(@RequestBody @Valid UnionRequest request) {
        HashSet<Integer> union = new HashSet<>(request.getLeft());
        union.addAll(request.getRight());
        LOG.info("UNION(({}, {}) = {}", request.getLeft(), request.getRight(), union);
        return new UnionResponse(union);
    }

    @RequestMapping(path = "/substract", method = RequestMethod.POST)
    public SubstractionResponse substract(@RequestBody @Valid SubstractionRequest request) {
        int difference = ArithmeticUtils.subAndCheck(request.getMinuend(), request.getSubstrachend());
        LOG.info("{} - {} = {}", request.getMinuend(), request.getSubstrachend(), difference);
        return new SubstractionResponse(difference);
    }
}
