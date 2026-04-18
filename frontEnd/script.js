const API = "http://localhost:8080/pets";

window.onload = listaPets;

function listaPets() {
    fetch(API)
    .then(res => res.json())
    .then(data => {

        const disp = document.getElementById("disponiveis");
        const adot = document.getElementById("adotados");

        disp.innerHTML = "";
        adot.innerHTML = "";

        data.forEach(pet => {

            const div = document.createElement("div");
            div.classList.add("pet");

            if (pet.adotado) {
                div.classList.add("adotado");
            }

            div.innerHTML = `
               <img src="${pet.imagem || 'https://placedog.net/400/300'}" class="pet-img">

                <strong>${pet.nome}</strong><br>
                ${pet.especie}<br><br>

                ${!pet.adotado 
                    ? `<button class="btn-adotar" onclick="adotarPet(${pet.id})">Adotar</button>` 
                    : ""
                }

                <button class="btn-delete" onclick="deletarPet(${pet.id})">Deletar</button>
            `;

            if (pet.adotado) {
                adot.appendChild(div);
            } else {
                disp.appendChild(div);
            }
        });
    });
}

function criarPet() {
    const imagem = document.getElementById("imagem").value;
    const nome = document.getElementById("nome").value;
    const especie = document.getElementById("especie").value;

    fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nome, especie, imagem })
    })
    .then(() => {
        listaPets();
    });
}

function adotarPet(id) {
    fetch(`${API}/${id}/adotar`, {
        method: "PATCH"
    })
    .then(() => listaPets());
}

function deletarPet(id) {
    fetch(`${API}/${id}`, {
        method: "DELETE"
    })
    .then(() => listaPets());
}