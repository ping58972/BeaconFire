package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon("Bulbasaur", "grass", 100),
                new Pokemon("Charmander", "fire", 200),
                new Pokemon("Squirtle", "water", 333),
                new Pokemon("Pikachu", "electric", 420),
                new Pokemon("Ninetales", "fire", 123),
                new Pokemon("Poliwag", "water", 22),
                new Pokemon("Poliwag", "water", 22)
        );

        // print out each item of list
        System.out.println("Display list of pokemon");
        pokemons.stream().forEach(System.out::println);

        // map
        System.out.println("\nGet list of pokemon names");
        List<String> names = pokemons
                .stream()
                .map(pokemon -> pokemon.getName())
                .collect(Collectors.toList());
        names.forEach((System.out::println));

//         filter
        System.out.println("\nFilter pokemon to include those whose CP is greater than 200:");
        pokemons.stream()
                .filter(pokemon -> pokemon.getCp() > 200)
                .forEach(System.out::println);

        // sorted
        System.out.println("\nSort pokemon by their CP in descending order:");
        pokemons.stream()
                .sorted((p1, p2) -> p2.getCp() - p1.getCp())
                .forEach(System.out::println);

//        // distinct
        System.out.println("\nGet unique pokemon:");
        pokemons.stream().distinct().forEach(System.out::println);
//
        // findAny
        // Optional can contain either an actual object or it can contain a null
        System.out.println("\nFind a possible pokemon whose type is water");
        Optional<Pokemon> possiblePokemon = pokemons
                .stream()
                .filter(p -> p.getType().equals("water"))
                .findAny();
        possiblePokemon.ifPresent(System.out::println);

        // collect to a list
        List<Pokemon> waterPokemons = pokemons
                .stream()
                .filter(p -> p.getType().equals("water"))
                .collect(Collectors.toList());

        // collect to a map
        Map<String, Pokemon> map = pokemons
                .stream()
                .distinct()
                .collect(Collectors.toMap(Pokemon::getName, Function.identity()));

        // toArray
        System.out.println("\nConvert the pokemon list to an array:");
        Pokemon[] pokemonArray = pokemons
                .stream()
                .distinct()
                .toArray(Pokemon[]::new);
        System.out.println(Arrays.toString(pokemonArray));

    }
}
