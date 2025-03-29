const pokemonContainer = document.getElementById('pokemon-list');
const generationSelector = document.getElementById('generation');

// Function to fetch Pokémon data from the API based on the selected generation
async function fetchPokemonData(generation) {
    const apiUrl = `https://pokeapi.co/api/v2/generation/${generation}/`;
    try {
        const response = await fetch(apiUrl);
        const data = await response.json();
        displayPokemon(data.pokemon_species);
    } catch (error) {
        console.error("Error fetching Pokémon data:", error);
    }
}

// Function to display Pokémon data
function displayPokemon(pokemonList) {
    pokemonContainer.innerHTML = ''; // Clear previous list
    pokemonList.forEach(pokemon => {
        const listItem = document.createElement('li');
        listItem.textContent = pokemon.name.charAt(0).toUpperCase() + pokemon.name.slice(1);
        pokemonContainer.appendChild(listItem);
    });
}

// Event listener for changing generation
generationSelector.addEventListener('change', function() {
    const generation = generationSelector.value;
    fetchPokemonData(generation);
});

// Initialize the Pokémon list for Generation 1
document.addEventListener('DOMContentLoaded', function() {
    fetchPokemonData(1); // Fetch Generation 1 Pokémon by default
});
