package linkedin.profile.repository;

import linkedin.profile.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    public Long findByHouseNoAndStreetAndCityAndCountry(String houseNum, String street, String city, String country);
}
