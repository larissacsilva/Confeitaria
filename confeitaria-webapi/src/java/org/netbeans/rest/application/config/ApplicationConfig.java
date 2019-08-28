package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(controller.CaixaController.class);
        resources.add(controller.ClienteController.class);
        resources.add(controller.FornecedorController.class);
        resources.add(controller.FuncionarioController.class);
        resources.add(controller.IngredienteController.class);
        resources.add(controller.ItemPedidoController.class);
        resources.add(controller.PedidoController.class);
        resources.add(controller.PratoController.class);
    }
    
}
