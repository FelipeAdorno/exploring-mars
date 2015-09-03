package br.com.elo7.probe.model.plateau;

import br.com.elo7.probe.repository.PlateauRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * The type Plateau.
 *
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
@Configurable
public class PlateauDomainModelImpl implements PlateauDomainModel {

    private Integer vertical;
    private Integer horizontal;

    public PlateauDomainModelImpl create(final Integer vertical, final Integer horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        PlateauRepository.newInstance(vertical, horizontal);
        return this;
    }

    public Integer getVertical() {
        return PlateauRepository.getInstance().getVertical();
    }

    public Integer getHorizontal() {
        return PlateauRepository.getInstance().getHorizontal();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
