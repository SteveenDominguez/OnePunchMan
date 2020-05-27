package OnePunchManWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import OnePunchManWeb.model.Combate;
import OnePunchManWeb.model.CombateXHeroe;
import OnePunchManWeb.model.CombateXMonstruo;
import OnePunchManWeb.model.Comida;
import OnePunchManWeb.model.Heroe;
import OnePunchManWeb.model.HeroeXVideojuego;
import OnePunchManWeb.model.HeroeXVisita;
import OnePunchManWeb.model.Monstruo;
import OnePunchManWeb.model.Patrocinador;
import OnePunchManWeb.model.PatrocinadorXHeroe;
import OnePunchManWeb.model.PatrocinadorXMonstruo;
import OnePunchManWeb.model.Videojuego;
import OnePunchManWeb.model.Visita;
import OnePunchManWeb.model.VisitaXComida;
import OnePunchManWeb.service.ICombaXHeroService;
import OnePunchManWeb.service.ICombaXMonsService;
import OnePunchManWeb.service.ICombateService;
import OnePunchManWeb.service.IComidaService;
import OnePunchManWeb.service.IHerXVidService;
import OnePunchManWeb.service.IHerXVisService;
import OnePunchManWeb.service.IHeroeService;
import OnePunchManWeb.service.IMonstruoService;
import OnePunchManWeb.service.IPatroXHeroService;
import OnePunchManWeb.service.IPatroXMonsService;
import OnePunchManWeb.service.IPatrocinadorService;
import OnePunchManWeb.service.IVideojuegoService;
import OnePunchManWeb.service.IVisXComService;
import OnePunchManWeb.service.IVisitaService;

@Controller
public class HomeController {
	@Autowired
	IComidaService com;
	@Autowired
	IVisitaService vis;
	@Autowired
	IVisXComService vxc;
	@Autowired
	IHeroeService hero;
	@Autowired
	IVideojuegoService vid;
	@Autowired
	IHerXVidService hxv;
	@Autowired
	IPatrocinadorService patro;
	@Autowired
	IMonstruoService mons;
	@Autowired
	ICombateService comba;
	@Autowired
	IPatroXHeroService pxh;
	@Autowired
	IPatroXMonsService pxm;
	@Autowired
	ICombaXHeroService cxh;
	@Autowired
	ICombaXMonsService cxm;
	@Autowired
	IHerXVisService heroxvis;

	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String HomePage() {
		return "home";
	}

	@RequestMapping(value= "/listarComidas", method = RequestMethod.GET)
	public String ListarComidas(Model modelo) {
		List<Comida> comidas= com.listarComidas();
		modelo.addAttribute("comidas",comidas);
		return "listarComidas";
	}


	//Controladores para insertar regiones
	@RequestMapping(value = "/insertarComidas")
	public String InsertarComidas() {
		return "insertarComidas";
	}

	@PostMapping(value = "/guardarComidas")
	public String guardarComidas(@ModelAttribute Comida comida, BindingResult result,Model modelo) {
		com.guardar(comida);
		List<Comida> comidas= com.listarComidas();
		modelo.addAttribute("comidas",comidas);
		return "listarComidas";
	}
	//Fin controladores para insertar regiones

	@RequestMapping(value = "/eliminarComida/{id}")
	public String eliminarComida(@PathVariable("id") int id,Model modelo) {
		List<VisitaXComida> visxcom= vxc.listarVXCPorComida(id);
		for (int i = 0; i < visxcom.size(); i++) {
			vxc.eliminar(visxcom.get(i).getId());
		}
		com.eliminar(id);
		List<Comida> comidas=com.listarComidas();
		modelo.addAttribute("comidas",comidas);
		return "redirect:/listarComidas";
	}

	@RequestMapping(value="/editarComida/{id}")
	public String editarComida(@PathVariable("id") int id,Model modelo) {
		Comida eldato=com.encontrarPorId(id);
		modelo.addAttribute("comida",eldato);
		return "editarComidas";
	}

	@PostMapping(value="/editarComida/guardarNuevaComida")
	public String guardarNuevaComida(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre)
	{
		Comida eldato=com.encontrarPorId(id);
		eldato.setId(id);
		eldato.setNombre(nombre);
		com.guardar(eldato);
		List<Comida> comidas=com.listarComidas();
		modelo.addAttribute("comidas",comidas);
		return "redirect:/listarComidas";
	}

	@RequestMapping(value= "/listarVisitas", method = RequestMethod.GET)
	public String ListarVisitas(Model modelo) {
		List<Visita> visitas= vis.listarVisitas();
		modelo.addAttribute("visitas",visitas);
		return "listarVisitas";
	}

	@RequestMapping(value= "/listarComidaDeVisitas", method = RequestMethod.GET)
	public String ListarComidaDeVisitas(Model modelo) {
		List<Comida> comidaDeVisitas= com.listarComidasPorVisita();
		List<Visita> visitasConComida= vis.listarVisitasYComida();
		modelo.addAttribute("comidaDeVisitas",comidaDeVisitas);
		modelo.addAttribute("visitasConComida", visitasConComida);
		return "listarComidaDeVisitas";
	}
	
	@RequestMapping(value= "/listarHeroeDeVisitas", method = RequestMethod.GET)
	public String ListarHeroeDeVisitas(Model modelo) {
		List<Heroe> heroeDeVisitas= hero.listarHeroesPorVisita();
		List<Visita> visitasConHeroe= vis.listarVisitasYHeroe();
		modelo.addAttribute("heroeDeVisitas",heroeDeVisitas);
		modelo.addAttribute("visitasConHeroe", visitasConHeroe);
		return "listarHeroeDeVisitas";
	}

	//Controladores para insertar regiones
	@RequestMapping(value = "/insertarVisitas")
	public String InsertarVisitas(Model modelo) {
		List<Heroe> heroes= hero.listarHeroes();
		List<Comida> comidas= com.listarComidas();
		modelo.addAttribute("comidas",comidas);
		modelo.addAttribute("heroes",heroes);
		return "insertarVisitas";
	}

	@PostMapping(value = "/guardarVisitas")
	public String guardaVisitas(Model modelo, @RequestParam("id") int id,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("fecha") String fecha,
			@RequestParam("comidas[]") List<Integer> id_comidas,
			@RequestParam("heroes[]") List<Integer> id_heroes) {
		Visita visita= new Visita(id,descripcion,fecha);
		vis.guardar(visita);
		VisitaXComida visxcom;
		HeroeXVisita heroxvisi;
		for (int i = 0; i < id_comidas.size(); i++) {
			Comida comida= com.encontrarPorId(id_comidas.get(i).intValue());
			visxcom= new VisitaXComida(visita,comida);
			vxc.guardar(visxcom);
		}
		for (int i = 0; i < id_heroes.size(); i++) {
			Heroe heroe= hero.encontrarPorId(id_heroes.get(i).intValue());
			heroxvisi= new HeroeXVisita(visita,heroe);
			heroxvis.guardar(heroxvisi);
		}
		List<Visita> visitas= vis.listarVisitas();
		modelo.addAttribute("visitas",visitas);
		return "listarVisitas";
	}
	//Fin controladores para insertar regiones

	@RequestMapping(value = "/eliminarVisita/{id}")
	public String eliminarVisita(@PathVariable("id") int id,Model modelo) {
		List<HeroeXVisita> herxvis= heroxvis.listarHXVPorVisita(id);
		for (int i = 0; i < herxvis.size(); i++) {
			heroxvis.eliminar(herxvis.get(i).getId());
		}
		List<VisitaXComida> visxcom= vxc.listarVXCPorVisita(id);
		for (int i = 0; i < visxcom.size(); i++) {
			vxc.eliminar(visxcom.get(i).getId());
		}
		vis.eliminar(id);
		List<Visita> visitas=vis.listarVisitas();
		modelo.addAttribute("visitas",visitas);
		return "redirect:/listarVisitas";
	}

	@RequestMapping(value="/editarVisita/{id}")
	public String editarVisita(@PathVariable("id") int id,Model modelo) {
		Visita eldato=vis.encontrarPorId(id);
		modelo.addAttribute("visita",eldato);
		return "editarVisitas";
	}

	@PostMapping(value="/editarVisita/guardarNuevaVisita")
	public String guardarNuevaVisita(Model modelo, @RequestParam("id") int id, 
			@RequestParam("descripcion") String descripcion,
			@RequestParam("fecha") String fecha)
	{
		Visita eldato=vis.encontrarPorId(id);
		eldato.setId(id);
		eldato.setDescripcion(descripcion);
		eldato.setFecha(fecha);
		vis.guardar(eldato);
		return "redirect:/listarVisitas";
	}

	@RequestMapping(value= "/listarHeroes", method = RequestMethod.GET)
	public String ListarHeores(Model modelo) {
		List<Heroe> heroes= hero.listarHeroes();
		modelo.addAttribute("heroes",heroes);
		return "listarHeroes";
	}
	//Controladores para insertar heroe
	@RequestMapping(value = "/insertarHeroes")
	public String InsertarHeroes(Model model) {
		List<Heroe> heroes= hero.listarHeroes();
		model.addAttribute("heroes",heroes);
		return "insertarHeroes";
	}

	@PostMapping(value = "/guardarHeroes")
	public String guardarHeroes(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("rango") String rango, @RequestParam("habilidad") String habilidad, @RequestParam("residencia") String residencia,
	@RequestParam("telefono") String telefono,  @RequestParam("tiene_celula") String tiene_celula, @RequestParam("fan") int id_fan) {
		System.out.println(id_fan);
		Heroe fan= hero.encontrarPorId(id_fan);
		Heroe heroe= new Heroe(id, nombre, rango, habilidad, residencia, telefono, tiene_celula, fan);
		hero.guardar(heroe);
		List<Heroe> heroes= hero.listarHeroes();
		modelo.addAttribute("heroes",heroes);
		return "listarHeroes";
	}
	//Fin controladores para insertar heroes

	@RequestMapping(value = "/eliminarHeroe/{id}")
	public String eliminarHeroe(@PathVariable("id") int id,Model modelo) {
		hero.eliminar(id);
		List<Heroe>heroes=hero.listarHeroes();
		modelo.addAttribute("heroes",heroes);
		
		List<HeroeXVisita> heroxvisit = heroxvis.listarHXVPorHeroe(id);
		for (int i=0; i< heroxvisit.size(); i++){
			heroxvis.eliminar(heroxvisit.get(i).getId());
			}
		return "redirect:/listarHeroes";
	}

	@RequestMapping(value="/editarHeroe/{id}")
	public String editarHeroe(@PathVariable("id") int id,Model modelo) {
		List<Heroe> heroes= hero.listarHeroes();
		modelo.addAttribute("heroes",heroes);
		Heroe eldato=hero.encontrarPorId(id);
		modelo.addAttribute("heroe",eldato);
		return "editarHeroes";
	}

	@PostMapping(value="/editarHeroe/guardarNuevoHeroe")
	public String guardarNuevoSubdito(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("rango") String rango, @RequestParam("habilidad") String habilidad, @RequestParam("residencia") String residencia,
	@RequestParam("telefono") String telefono,  @RequestParam("tiene_celula") String tiene_celula, @RequestParam("fan") int id_fan)
	{
		Heroe eldato=hero.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setRango(rango);
		eldato.setHabilidad(habilidad);
		eldato.setResidencia(residencia);
		eldato.setTelefono(telefono);
		eldato.setTiene_celula(tiene_celula);
		Heroe fan= hero.encontrarPorId(id_fan);
		eldato.setFan(fan);

		hero.guardar(eldato);
		List<Heroe> heroes=hero.listarHeroes();
		modelo.addAttribute("heroes",heroes);
		return "redirect:/listarHeroes";
	}

	@RequestMapping(value= "/listarVideojuegos", method = RequestMethod.GET)
	public String ListarVideojuegos(Model modelo) {
		List<Videojuego> videojuegos= vid.listarVideojuegos();
		modelo.addAttribute("videojuegos",videojuegos);
		return "listarVideojuegos";
	}


	//Controladores para insertar regiones
	@RequestMapping(value = "/insertarVideojuegos")
	public String InsertarVideojuegos() {
		return "insertarVideojuegos";
	}

	@PostMapping(value = "/guardarVideojuegos")
	public String guardarVideojuegos(@ModelAttribute Videojuego videojuego, BindingResult result,Model modelo) {
		vid.guardar(videojuego);
		List<Videojuego> videojuegos= vid.listarVideojuegos();
		modelo.addAttribute("videojuegos",videojuegos);
		return "listarVideojuegos";
	}
	//Fin controladores para insertar regiones


	@RequestMapping(value = "/eliminarVideojuego/{id}")
	public String eliminarVideojuego(@PathVariable("id") int id,Model modelo) {
		List<HeroeXVideojuego> herxvid= hxv.listarHXVPorVideojuego(id);
		for (int i = 0; i < herxvid.size(); i++) {
			hxv.eliminar(herxvid.get(i).getId());
		}
		vid.eliminar(id);
		List<Videojuego> videojuegos=vid.listarVideojuegos();
		modelo.addAttribute("videojuegos",videojuegos);
		return "redirect:/listarVideojuegos";
	}

	@RequestMapping(value="/editarVideojuego/{id}")
	public String editarVideojuego(@PathVariable("id") int id,Model modelo) {
		Videojuego eldato=vid.encontrarPorId(id);
		modelo.addAttribute("videojuego",eldato);
		return "editarVideojuegos";
	}

	@PostMapping(value="/editarVideojuego/guardarNuevoVideojuego")
	public String guardarNuevoVideojuego(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre)
	{
		Videojuego eldato=vid.encontrarPorId(id);
		eldato.setId(id);
		eldato.setNombre(nombre);
		vid.guardar(eldato);
		List<Videojuego> videojuegos=vid.listarVideojuegos();
		modelo.addAttribute("videojuegos",videojuegos);
		return "redirect:/listarVideojuegos";
	}

	@RequestMapping(value= "/listarPartidas", method = RequestMethod.GET)
	public String ListarPartidas(Model modelo) {
		List<HeroeXVideojuego> partidas=hxv.listarPartidas();
		modelo.addAttribute("partidas",partidas);
		return "listarPartidas";
	}


	//Controladores para insertar regiones
	@RequestMapping(value = "/insertarPartidas")
	public String InsertarPartidas(Model modelo) {
		List<Heroe> heroes= hero.listarHeroes();
		List<Videojuego> videojuegos= vid.listarVideojuegos();
		modelo.addAttribute("videojuegos", videojuegos);
		modelo.addAttribute("heroes", heroes);
		return "insertarPartidas";
	}

	@PostMapping(value = "/guardarPartidas")
	public String guardarPartidas(Model modelo, @RequestParam("fecha") 
	String fecha, @RequestParam("ganador") int id_ganador, 
	@RequestParam("perdedor") int id_perdedor,
	@RequestParam("videojuego") int id_videojuego) {
		Heroe ganador= hero.encontrarPorId(id_ganador);
		Heroe perdedor= hero.encontrarPorId(id_perdedor);
		Videojuego videojuego= vid.encontrarPorId(id_videojuego);
		HeroeXVideojuego partida= new HeroeXVideojuego(fecha,ganador,perdedor,videojuego);
		hxv.guardar(partida);
		List<HeroeXVideojuego> partidas= hxv.listarPartidas();
		modelo.addAttribute("partidas",partidas);
		return "listarPartidas";
	}
	//Fin controladores para insertar regiones

	@RequestMapping(value = "/eliminarPartida/{id}")
	public String eliminarPartida(@PathVariable("id") int id,Model modelo) {
		hxv.eliminar(id);
		List<HeroeXVideojuego> partidas=hxv.listarPartidas();
		modelo.addAttribute("partidas",partidas);
		return "redirect:/listarPartidas";
	}

	@RequestMapping(value="/editarPartida/{id}")
	public String editarPartida(@PathVariable("id") int id,Model modelo) {
		HeroeXVideojuego eldato=hxv.encontrarPorId(id);
		List<Heroe> heroes= hero.listarHeroes();
		List<Videojuego> videojuegos= vid.listarVideojuegos();
		modelo.addAttribute("partida",eldato);
		modelo.addAttribute("heroes", heroes);
		modelo.addAttribute("videojuegos",videojuegos);
		return "editarPartidas";
	}

	@PostMapping(value="/editarPartida/guardarNuevaPartida")
	public String guardarNuevaPartida(Model modelo, @RequestParam("id") int id, @RequestParam("fecha") 
	String fecha, @RequestParam("ganador") int id_ganador, @RequestParam("perdedor") int id_perdedor,
	@RequestParam("videojuego") int id_videojuego)
	{
		HeroeXVideojuego eldato=hxv.encontrarPorId(id);
		eldato.setId(id);
		eldato.setFecha(fecha);
		Heroe ganador= hero.encontrarPorId(id_ganador);
		Heroe perdedor= hero.encontrarPorId(id_perdedor);
		Videojuego videojuego= vid.encontrarPorId(id_videojuego);
		eldato.setGanador(ganador);
		eldato.setPerdedor(perdedor);
		eldato.setVideojuego(videojuego);
		hxv.guardar(eldato);
		List<HeroeXVideojuego> partidas=hxv.listarPartidas();
		modelo.addAttribute("partidas", partidas);
		return "redirect:/listarPartidas";
	}

	@RequestMapping(value= "/listarPatrocinadores", method = RequestMethod.GET)
	public String ListarPatrocinadores(Model modelo) {
		List<Patrocinador> patrocinadores= patro.listarPatrocinadores();
		modelo.addAttribute("patrocinadores",patrocinadores);
		return "listarPatrocinadores";
	}

	@RequestMapping(value= "/listarPatrocinadoresDeHeroe/{id}", method = RequestMethod.GET)
	public String ListarPatrocinadoresDeHeroe(@PathVariable("id") int id_heroe,Model modelo) {
		List<Patrocinador> patrocinadores= patro.listarPatrocinadoresPorHeroe(id_heroe);
		modelo.addAttribute("patrocinadores",patrocinadores);
		return "listarPatrocinadores";
	}

	@RequestMapping(value= "/listarPatrocinadoresDeMonstruo/{id}", method = RequestMethod.GET)
	public String ListarPatrocinadoresDeMonstruo(@PathVariable("id") int id_monstruo,Model modelo) {
		List<Patrocinador> patrocinadores= patro.listarPatrocinadoresPorMonstruo(id_monstruo);
		modelo.addAttribute("patrocinadores",patrocinadores);
		return "listarPatrocinadores";
	}
	//Controladores para insertar Patrocinador
	@RequestMapping(value = "/insertarPatrocinadores")
	public String InsertarPatrocinadores() {
		return "insertarPatrocinadores";
	}

	@PostMapping(value = "/guardarPatrocinadores")
	public String guardarPatrocinadores(@ModelAttribute Patrocinador patrocinador, BindingResult result,Model modelo) {
		patro.guardar(patrocinador);
		List<Patrocinador> patrocinadores= patro.listarPatrocinadores();
		modelo.addAttribute("patrocinadores",patrocinadores);
		return "listarPatrocinadores";
	}
	//Fin controladores para insertar Patrocinador

	@RequestMapping(value = "/eliminarPatrocinador/{id}")
	public String eliminarPatrocinador(@PathVariable("id") int id,Model modelo) {
		List<PatrocinadorXHeroe> patroxhero= pxh.listarPXHPorPatrocinador(id);
		for (int i = 0; i < patroxhero.size(); i++) {
			pxh.eliminar(patroxhero.get(i).getId());
		}
		patro.eliminar(id);
		List<Patrocinador> patrocinadores=patro.listarPatrocinadores();
		modelo.addAttribute("patrocinadores",patrocinadores);
		return "redirect:/listarPatrocinadores";
	}


	@RequestMapping(value="/editarPatrocinador/{id}")
	public String editarPatrocinador(@PathVariable("id") int id,Model modelo) {
		Patrocinador eldato=patro.encontrarPorId(id);
		modelo.addAttribute("patrocinador",eldato);
		return "editarPatrocinadores";
	}

	@PostMapping(value="/editarPatrocinador/guardarNuevoPatrocinador")
	public String guardarNuevoPatrocinador(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre,  @RequestParam("dinero") int dinero)
	{
		Patrocinador eldato=patro.encontrarPorId(id);
		eldato.setId(id);
		eldato.setNombre(nombre);
		eldato.setDinero(dinero);
		patro.guardar(eldato);
		List<Patrocinador> patrocinadores=patro.listarPatrocinadores();
		modelo.addAttribute("patrocinadores",patrocinadores);
		return "redirect:/listarPatrocinadores";
	}

	@RequestMapping(value= "/listarMonstruos", method = RequestMethod.GET)
	public String ListarMonstruos(Model modelo) {
		List<Monstruo> monstruos= mons.listarMonstruos();
		modelo.addAttribute("monstruos",monstruos);
		return "listarMonstruos";
	}


	//Controladores para insertar Monstruo
	@RequestMapping(value = "/insertarMonstruos")
	public String InsertarMonstruos() {
		return "insertarMonstruos";
	}

	@PostMapping(value = "/guardarMonstruos")
	public String guardarMonstruos(@ModelAttribute Monstruo monstruo, BindingResult result,Model modelo) {
		mons.guardar(monstruo);
		List<Monstruo> monstruos= mons.listarMonstruos();
		modelo.addAttribute("monstruos",monstruos);
		return "listarMonstruos";
	}
	//Fin controladores para insertar Monstruo

	@RequestMapping(value = "/eliminarMonstruo/{id}")
	public String eliminarMonstruo(@PathVariable("id") int id,Model modelo) {
		mons.eliminar(id);
		List<Monstruo> monstruos=mons.listarMonstruos();
		modelo.addAttribute("monstruos",monstruos);
		return "redirect:/listarMonstruos";
	}


	@RequestMapping(value="/editarMonstruo/{id}")
	public String editarMonstruo(@PathVariable("id") int id,Model modelo) {
		Monstruo eldato=mons.encontrarPorId(id);
		modelo.addAttribute("monstruo",eldato);
		return "editarMonstruos";
	}

	@PostMapping(value="/editarMonstruo/guardarNuevoMonstruo")
	public String guardarNuevoMonstruo(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre,  @RequestParam("amenaza") String amenaza,  @RequestParam("tiene_celula") String tiene_celula)
	{
		Monstruo eldato=mons.encontrarPorId(id);
		eldato.setId(id);
		eldato.setNombre(nombre);
		eldato.setAmenaza(amenaza);
		eldato.setTiene_celula(tiene_celula);
		mons.guardar(eldato);
		List<Monstruo> monstruos=mons.listarMonstruos();
		modelo.addAttribute("monstruos",monstruos);
		return "redirect:/listarMonstruos";
	}

	@RequestMapping(value= "/listarCombates", method = RequestMethod.GET)
	public String ListarCombates(Model modelo) {
		List<Combate> combates= comba.listarCombates();
		modelo.addAttribute("combates",combates);
		return "listarCombates";
	}


	//Controladores para insertar Combate
	@RequestMapping(value = "/insertarCombates")
	public String InsertarCombates() {
		return "insertarCombates";
	}
	
	@RequestMapping(value= "/listarCombatesDeHeroe/{id}", method = RequestMethod.GET)
	public String ListarCombatesDeHeroe(@PathVariable("id") int id_heroe,Model modelo) {
		List<Combate> combates= comba.listarCombatesPorHeroe(id_heroe);
		modelo.addAttribute("combates",combates);
		return "listarCombates";
	}
	
	@RequestMapping(value= "/listarCombatesDeMonstruo/{id}", method = RequestMethod.GET)
	public String ListarCombatesDeMonstruo(@PathVariable("id") int id_monstruo,Model modelo) {
		List<Combate> combates= comba.listarCombatesPorMonstruo(id_monstruo);
		modelo.addAttribute("combates",combates);
		return "listarCombates";
	}
	
	@PostMapping(value = "/guardarCombates")
	public String guardarCombates(@ModelAttribute Combate combate, BindingResult result,Model modelo) {
		comba.guardar(combate);
		List<Combate> combates= comba.listarCombates();
		modelo.addAttribute("combates",combates);
		return "listarCombates";
	}
	//Fin controladores para insertar Combate

	@RequestMapping(value = "/eliminarCombate/{id}")
	public String eliminarCombate(@PathVariable("id") int id,Model modelo) {
		comba.eliminar(id);
		List<Combate> combates=comba.listarCombates();
		modelo.addAttribute("combates",combates);
		return "redirect:/listarCombates";
	}


	@RequestMapping(value="/editarCombate/{id}")
	public String editarCombate(@PathVariable("id") int id,Model modelo) {
		Combate eldato=comba.encontrarPorId(id);
		modelo.addAttribute("combate",eldato);
		return "editarCombates";
	}

	@PostMapping(value="/editarCombate/guardarNuevoCombate")
	public String guardarNuevoCombate(Model modelo, @RequestParam("id") int id, @RequestParam("fecha") 
	String fecha,  @RequestParam("ganador") String ganador,  @RequestParam("perdedor") String perdedor)
	{
		Combate eldato=comba.encontrarPorId(id);
		eldato.setId(id);
		eldato.setFecha(fecha);
		eldato.setGanador(ganador);
		eldato.setPerdedor(perdedor);
		comba.guardar(eldato);
		List<Combate> combates=comba.listarCombates();
		modelo.addAttribute("combates",combates);
		return "redirect:/listarCombates";
	}
	
	@RequestMapping(value = "/insertarPatrocinadorXHeroe")
	public String InsertarPatrocinadorXHeroe(Model model) {
		List<Patrocinador> patrocinadores= patro.listarPatrocinadores();
		model.addAttribute("patrocinadores",patrocinadores);
		List<Heroe> heroes= hero.listarHeroes();
		model.addAttribute("heroes",heroes);
		return "insertarPatrocinadorXHeroe";
	}

	@PostMapping(value = "/guardarPatrocinadorXHeroe")
	public String guardarPatrocinadorXHeroe(Model modelo, @RequestParam("id") int id, @RequestParam("patrocinador") int id_patrocinador,
			 @RequestParam("heroe") int id_heroe) {
		Patrocinador patroc= patro.encontrarPorId(id_patrocinador);
		Heroe heroe= hero.encontrarPorId(id_heroe);
		PatrocinadorXHeroe eldato= new PatrocinadorXHeroe(id, patroc, heroe);
		pxh.guardar(eldato);
		return "redirect:/listarHeroes";
	}
	
	@RequestMapping(value = "/insertarPatrocinadorXMonstruo")
	public String InsertarPatrocinadorXMonstruo(Model model) {
		List<Patrocinador> patrocinadores= patro.listarPatrocinadores();
		model.addAttribute("patrocinadores",patrocinadores);
		List<Monstruo> monstruos= mons.listarMonstruos();
		model.addAttribute("monstruos",monstruos);
		return "insertarPatrocinadorXMonstruo";
	}

	@PostMapping(value = "/guardarPatrocinadorXMonstruo")
	public String guardarPatrocinadorXMonstruo(Model modelo, @RequestParam("id") int id, @RequestParam("patrocinador") int id_patrocinador,
			 @RequestParam("monstruo") int id_monstruo) {
		Patrocinador patroc= patro.encontrarPorId(id_patrocinador);
		Monstruo monstruo= mons.encontrarPorId(id_monstruo);
		PatrocinadorXMonstruo eldato= new PatrocinadorXMonstruo(id, patroc, monstruo);
		pxm.guardar(eldato);
		return "redirect:/listarMonstruos";
	}
	
	@RequestMapping(value = "/insertarCombateXHeroeYCombateXMonstruo/{id}")
	public String InsertarCombateXHeroeYCombateXMonstruo(Model model, @PathVariable("id") int id) {
		Combate comb = comba.encontrarPorId(id);
		model.addAttribute("combate", comb);
		List<Heroe> heroes= hero.listarHeroes();
		model.addAttribute("heroes",heroes);
		List<Monstruo> monstruos= mons.listarMonstruos();
		model.addAttribute("monstruos",monstruos);
		return "insertarCombateXHeroeYCombateXMonstruo";
	}

	@PostMapping(value = "/guardarCombateXHeroeYCombateXMonstruo")
	public String guardarCombateXHeroeYCombateXMonstruo(Model modelo, @RequestParam("id") int id, @RequestParam("monstruo") int id_monstruo,
			 @RequestParam("heroe") int id_heroe) {
		Combate combate = comba.encontrarPorId(id);
		Monstruo monstruo= mons.encontrarPorId(id_monstruo);
		Heroe heroe= hero.encontrarPorId(id_heroe);
		CombateXHeroe eldato1= new CombateXHeroe(id, combate, heroe);
		cxh.guardar(eldato1);
		CombateXMonstruo eldato2= new CombateXMonstruo(id, combate, monstruo);
		cxm.guardar(eldato2);
		return "listarCombates";
	}

}
