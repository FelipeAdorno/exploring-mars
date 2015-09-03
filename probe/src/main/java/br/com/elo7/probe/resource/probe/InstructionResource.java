package br.com.elo7.probe.resource.probe;

import br.com.elo7.probe.model.enums.ProbeDirectionEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Instruction resource.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public class InstructionResource {

    List<ProbeDirectionEnum> instructions = new ArrayList<>();

    public List<ProbeDirectionEnum> getInstructions() {
        return instructions;
    }

    public void setInstructions(final List<ProbeDirectionEnum> instructions) {
        this.instructions = instructions;
    }
}
