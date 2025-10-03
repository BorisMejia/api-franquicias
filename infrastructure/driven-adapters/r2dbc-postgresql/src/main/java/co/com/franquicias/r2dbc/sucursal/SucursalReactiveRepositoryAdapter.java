package co.com.franquicias.r2dbc.sucursal;

import co.com.franquicias.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SucursalReactiveRepositoryAdapter extends ReactiveAdapterOperations<
    Object/* change for domain model */,
    Object/* change for adapter model */,
    String,
        SucursalReactiveRepository
> {
    public SucursalReactiveRepositoryAdapter(SucursalReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Object.class/* change for domain model */));
    }

}
