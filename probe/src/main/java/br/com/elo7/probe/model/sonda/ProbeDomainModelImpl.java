package br.com.elo7.probe.model.sonda;

import br.com.elo7.probe.model.enums.ProbeDirectionEnum;
import br.com.elo7.probe.model.exception.DuplicateProbeException;
import br.com.elo7.probe.model.exception.ProbeNotFoundException;
import br.com.elo7.probe.repository.ProbeRepository;
import br.com.elo7.probe.service.MoveServiceAdapter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;

/**
 * The type Sonda.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@Configurable
public class ProbeDomainModelImpl implements ProbeDomainModel {

    @Autowired
    private MoveServiceAdapter moveServiceAdapter;

    private final String name;
    private Position position;
    private List<ProbeDirectionEnum> instructions;

    public ProbeDomainModelImpl(final String name, final Position position, final List<ProbeDirectionEnum> instructions) {
        this.name = name;
        this.position = position;
        this.instructions = instructions;
    }

    public ProbeDomainModelImpl(final String name, List<ProbeDirectionEnum> instructions) {
        this.name = name;
        this.instructions = instructions;
        this.position = this.getPositionByProbeName();
    }

    public ProbeDomainModelImpl(final String name, final Position position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public ProbeDomainModelImpl runInstructions() {
        if(!CollectionUtils.isEmpty(this.instructions)) {
            for (ProbeDirectionEnum instruction : this.instructions) {
                if(instruction.equals(ProbeDirectionEnum.M)){
                    this.move();
                } else if(instruction.equals(ProbeDirectionEnum.L)) {
                    this.turnLeft();
                } else if(instruction.equals(ProbeDirectionEnum.R)) {
                    this.turnRight();
                }
            }
        }
        return this;
    }

    @Override
    public ProbeDomainModelImpl create() {
        if(ProbeRepository.getInstance().exist(this.name)) {
            throw new DuplicateProbeException();
        }
        this.updateProbePostion();
        return this;
    }

    @Override
    public ProbeDomainModelImpl move() {
        notNull(name, "invalid probe name");
        this.position = moveServiceAdapter.move(this.getPositionByProbeName());
        this.updateProbePostion();
        return this;
    }

    @Override
    public ProbeDomainModelImpl turnLeft() {
        notNull(name, "invalid probe name");
        this.position.setDirection(this.getPositionByProbeName().getDirection().getLeft());
        updateProbePostion();
        return this;
    }

    @Override
    public ProbeDomainModel turnRight() {
        notNull(name, "invalid probe name");
        this.position.setDirection(this.getPositionByProbeName().getDirection().getRight());
        updateProbePostion();
        return this;
    }

    private Position getPositionByProbeName() throws ProbeNotFoundException {
        return ProbeRepository.getInstance().getPositionByProbeName(this.name);
    }

    private void updateProbePostion() {
        ProbeRepository.getInstance().save(this.name, this.position);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o, "moveServiceAdapter");

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "moveServiceAdapter");
    }
}
