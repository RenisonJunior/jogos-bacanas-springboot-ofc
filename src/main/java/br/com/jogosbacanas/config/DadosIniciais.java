package br.com.jogosbacanas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.jogosbacanas.model.Desenvolvedora;
import br.com.jogosbacanas.model.Genero;
import br.com.jogosbacanas.model.Jogo;
import br.com.jogosbacanas.model.Plataforma;
import br.com.jogosbacanas.repository.DesenvolvedoraRepository;
import br.com.jogosbacanas.repository.GeneroRepository;
import br.com.jogosbacanas.repository.JogoRepository;
import br.com.jogosbacanas.repository.PlataformaRepository;

@Component
public class DadosIniciais implements CommandLineRunner {
    private final GeneroRepository generoRepository;
    private final DesenvolvedoraRepository desenvolvedoraRepository;
    private final PlataformaRepository plataformaRepository;
    private final JogoRepository jogoRepository;

    public DadosIniciais(GeneroRepository generoRepository,
                         DesenvolvedoraRepository desenvolvedoraRepository,
                         PlataformaRepository plataformaRepository,
                         JogoRepository jogoRepository) {
        this.generoRepository = generoRepository;
        this.desenvolvedoraRepository = desenvolvedoraRepository;
        this.plataformaRepository = plataformaRepository;
        this.jogoRepository = jogoRepository;
    }

    @Override
    public void run(String... args) {
        Genero acao = criarGenero("Ação e aventura");
        Genero narrativa = criarGenero("Aventura narrativa");
        Genero mundoAberto = criarGenero("Mundo aberto");
        Genero classico = criarGenero("Clássico");
        criarGenero("RPG");
        criarGenero("Outro");

        Desenvolvedora rocksteady = criarDesenvolvedora("Rocksteady Studios");
        Desenvolvedora dontnod = criarDesenvolvedora("Dontnod Entertainment");
        Desenvolvedora nintendo = criarDesenvolvedora("Nintendo");
        Desenvolvedora rockstar = criarDesenvolvedora("Rockstar Games");

        Plataforma batmanPlataformas = criarPlataforma("PlayStation 4, Xbox One e PC");
        Plataforma lifePlataformas = criarPlataforma("PC, PlayStation, Xbox e outras");
        Plataforma zeldaPlataformas = criarPlataforma("Nintendo Switch e Wii U");
        Plataforma redDeadPlataformas = criarPlataforma("PlayStation 4, Xbox One e PC");
        Plataforma n64 = criarPlataforma("Nintendo 64");

        if (jogoRepository.count() == 0) {
            salvarJogo("Batman: Arkham Knight",
                "Batman: Arkham Knight é um jogo de ação e aventura em que o jogador controla Batman enquanto protege Gotham City. A história começa quando o Espantalho ameaça a cidade e força seus habitantes a fugir. Durante a aventura, Batman investiga crimes, enfrenta vários inimigos e tenta descobrir os planos do misterioso Cavaleiro de Arkham. O jogo também permite explorar uma versão aberta de Gotham e usar o Batmóvel para se deslocar e combater adversários. O jogo combina combate corpo a corpo, furtividade, investigação e exploração. É uma opção interessante para quem gosta de super-heróis e de histórias policiais.",
                "https://upload.wikimedia.org/wikipedia/pt/5/5d/Batman_Arkham_Knight_Capa.jpg", 2015, acao, rocksteady, batmanPlataformas);
            salvarJogo("Life is Strange",
                "Life is Strange é uma aventura narrativa que acompanha Max Caulfield, uma estudante de fotografia que descobre ter a capacidade de voltar no tempo. Ao reencontrar sua amiga Chloe, ela começa a investigar acontecimentos estranhos na cidade de Arcadia Bay. O jogador conversa com personagens, explora lugares e toma decisões que podem mudar cenas e acontecimentos futuros. Algumas escolhas parecem pequenas, mas podem trazer consequências importantes para a história. O jogo aborda amizade, família, amadurecimento, perda e responsabilidade. É indicado para quem prefere histórias emocionantes e personagens marcantes, em vez de combates constantes.",
                "https://tse3.mm.bing.net/th/id/OIP.lD5veLpZCBXyYU22yfnIigHaHa?r=0&rs=1&pid=ImgDetMain&o=7&rm=3", 2015, narrativa, dontnod, lifePlataformas);
            salvarJogo("The Legend of Zelda: Breath of the Wild",
                "The Legend of Zelda: Breath of the Wild é uma aventura de mundo aberto ambientada em Hyrule. Link desperta depois de cem anos e precisa recuperar suas forças e descobrir como impedir Calamity Ganon, uma ameaça ao reino. O jogador pode explorar montanhas, florestas, vilas, ruínas e santuários em muitas ordens diferentes. Também é possível escalar, cozinhar, caçar, coletar materiais e usar o ambiente para superar obstáculos. A liberdade é uma das características mais importantes do jogo: o jogador decide para onde ir e como resolver muitos desafios. A exploração e a descoberta são tão importantes quanto os combates.",
                "https://tse4.mm.bing.net/th/id/OIP.sxLXtcv87kOzxje722iLdgHaL_?r=0&rs=1&pid=ImgDetMain&o=7&rm=3", 2017, mundoAberto, nintendo, zeldaPlataformas);
            salvarJogo("Red Dead Redemption 2",
                "Red Dead Redemption 2 é um jogo de ação e aventura ambientado em 1899, no fim do período conhecido como Velho Oeste. A história acompanha Arthur Morgan, membro da gangue de Dutch van der Linde, que tenta sobreviver enquanto o mundo ao seu redor muda. Além das missões principais, o jogador pode viajar a cavalo, explorar cidades e áreas selvagens, caçar, pescar e conhecer personagens pelo caminho. O mundo possui atividades e acontecimentos que ajudam a criar uma sensação de lugar vivo. As ações de Arthur influenciam seu nível de honra e algumas interações com outras pessoas. O jogo é conhecido por sua narrativa detalhada, seus personagens e seu ritmo mais contemplativo.",
                "https://tse4.mm.bing.net/th/id/OIP.8G4yWLW5t0U6zp8sCUt15AHaJJ?r=0&rs=1&pid=ImgDetMain&o=7&rm=3", 2018, mundoAberto, rockstar, redDeadPlataformas);
            salvarJogo("The Legend of Zelda: Ocarina of Time",
                "The Legend of Zelda: Ocarina of Time é uma aventura clássica da Nintendo. O jogador acompanha Link em uma jornada por Hyrule para impedir Ganondorf de conseguir um poder capaz de ameaçar o reino. Durante a história, Link explora vilas, campos, cavernas e templos. Os templos apresentam quebra-cabeças, inimigos e itens especiais que ajudam a avançar na aventura. A ocarina é um elemento importante: tocar melodias permite ativar acontecimentos e acessar determinados lugares. O jogo ajudou a estabelecer várias ideias que se tornaram comuns em aventuras tridimensionais.",
                "https://howlongtobeat.com/games/10035_The_Legend_of_Zelda_Ocarina_of_Time.png", 1998, classico, nintendo, n64);
        }
    }

    private Genero criarGenero(String nome) {
        return generoRepository.findByNomeIgnoreCase(nome).orElseGet(() -> {
            Genero genero = new Genero();
            genero.setNome(nome);
            return generoRepository.save(genero);
        });
    }

    private Desenvolvedora criarDesenvolvedora(String nome) {
        return desenvolvedoraRepository.findByNomeIgnoreCase(nome).orElseGet(() -> {
            Desenvolvedora desenvolvedora = new Desenvolvedora();
            desenvolvedora.setNome(nome);
            return desenvolvedoraRepository.save(desenvolvedora);
        });
    }

    private Plataforma criarPlataforma(String nome) {
        return plataformaRepository.findByNomeIgnoreCase(nome).orElseGet(() -> {
            Plataforma plataforma = new Plataforma();
            plataforma.setNome(nome);
            return plataformaRepository.save(plataforma);
        });
    }

    private void salvarJogo(String nome, String descricao, String imagemUrl, int ano,
                            Genero genero, Desenvolvedora desenvolvedora, Plataforma plataforma) {
        Jogo jogo = new Jogo();
        jogo.setNome(nome);
        jogo.setDescricao(descricao);
        jogo.setImagemUrl(imagemUrl);
        jogo.setAnoLancamento(ano);
        jogo.setGenero(genero);
        jogo.setDesenvolvedora(desenvolvedora);
        jogo.setPlataforma(plataforma);
        jogoRepository.save(jogo);
    }
}
