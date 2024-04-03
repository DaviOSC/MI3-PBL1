package br.uefs.ecomp.bazar;

import br.uefs.ecomp.bazar.model.ControllerBazarTest;
import br.uefs.ecomp.bazar.model.LeilaoTest;
import br.uefs.ecomp.bazar.model.ProdutoTest;
import br.uefs.ecomp.bazar.model.UsuarioTest;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({    
    UsuarioTest.class,
    ProdutoTest.class,
    LeilaoTest.class,
    ControllerBazarTest.class,})
public class AllTests {
}
