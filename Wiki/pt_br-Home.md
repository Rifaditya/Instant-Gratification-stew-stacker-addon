# 🍲 Instant Gratification: Stew Stacker Addon Wiki

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

> 📌 **Aviso sobre o Código-Fonte do Repositório**: A documentação desta Wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir alterações recentes ainda não lançadas no CurseForge ou Modrinth.

Bem-vindo à documentação técnica oficial do **Instant Gratification: Stew Stacker Addon**. Desenvolvido para Minecraft Fabric como uma extensão especializada para o **Stack Size Adjuster**, este mod elimina o acúmulo desnecessário de tigelas no inventário, permitindo empilhar ensopados de cogumelos, ensopados de coelho, sopas de beterraba e sopas suspeitas.

---

## 🧭 Portais de Documentação Multi-Versão

| Versão do Minecraft | Versão do Mod | Fabric Loader | Link do Portal |
| :--- | :---: | :---: | :--- |
| **Minecraft 26.2** | `1.0.2+26.2` | `>=0.19.1` | [[👉 Enter Minecraft 26.2 Documentation Portal|26.2-Home]] |
| **Minecraft 26.3** | `1.0.2+26.3` | `>=0.19.3` | [[👉 Enter Minecraft 26.3 Documentation Portal|26.3-Home]] |

---

## ⚡ Filosofia Central e Pilares Arquiteturais

1. **Espaço no Inventário Liberado**: Limite padrão de pilha aumentado para 16 (configurável até 2.147.483.647).
2. **Logística Ergonômica de Tigelas**: Ao consumir de uma pilha, a tigela de madeira volta ao inventário (ou cai no chão se estiver cheio).
3. **Sincronização de Rede em Tempo Real**: `StewLimitSyncPayload` e `broadcastFullState()` eliminam itens fantasmas.
4. **Coexistência com Outros Addons**: Detectado pelo `potion-stacker-addon`, que cede a autoridade sobre sopas para este mod.
5. **Zero Sobrecarga de Mixins**: Integração limpa via API com `StackSizeManager.registerOverride`.

---

## 📊 Matriz de GameRules Padrão

| Identificador GameRule | Tipo | Padrão | Intervalo | Itens afetados |
| :--- | :---: | :---: | :---: | :--- |
| `stew-stacker-addon:stew_limit` | Integer | `16` | 1 .. 2.147.483.647 | Ensopado de cogumelos, coelho, beterraba, sopa suspeita |

---

## 📚 Centros Essenciais de Documentação

* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[🔧 Troubleshooting & FAQ Guide|Troubleshooting-and-FAQ]]
* [[🛠️ Developer Setup & Build Guide|Developer-Setup-and-Building]]
* [[🏠 Return to Main Home Portal|Home]]
