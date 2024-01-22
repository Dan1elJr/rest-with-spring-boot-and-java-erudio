package br.com.erudio.mapper;

import java.util.ArrayList;
import java.util.List;
import com.github.dozermapper.core.Mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;

//Classe Mapeadora de entidades
public class DozerMapper {
	
	//Mapeador de entidades
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	//Mapear entidade
	public static <O, D> D parseObject(O origin, Class<D> destination) {

		return mapper.map(origin, destination);

	}
	
	//Mapear lista de entidadess
	public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {
		
		List<D> destinationObjects = new ArrayList<D>();
		
		for(O o : origin) {
			
			destinationObjects.add(mapper.map(o, destination));
		}
		
		return destinationObjects;

	}
}
