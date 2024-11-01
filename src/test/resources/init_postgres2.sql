CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE TABLE user_table(
                      ldap_login UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                      name varchar(100),
                      surname varchar(100));

INSERT INTO user_table (ldap_login, name, surname) VALUES
   ('3cf1f839-b7f6-4fad-81a5-5483ecd0192b', 'Waymjz', 'Lotnvg'),
   ('f627372c-7004-41cd-a2d0-b081c1b6e52d', 'Wbhyag', 'Hcowma'),
   ('313c2258-dfde-4595-aae1-cce215cd56be', 'Lbjduu', 'Qwcgom'),
   ('a3bac825-c9c0-48f2-8440-18337a186521', 'Tpikua', 'Bykemz'),
   ('a5a983a8-58fd-4d34-b3d8-1dbfd1e046d2', 'Vejxyq', 'Xbxkwg'),
   ('7b51c4d8-99c7-4e55-8b07-6c543376ff69', 'Gzyrnb', 'Mjzwru'),
   ('fa2c04b2-9624-4fa7-9c5f-38f82e5b93dc', 'Qvgthf', 'Bgmtsf'),
   ('57e5a4e5-f3c1-45db-b0fc-2b12ed91e0cd', 'Teavmr', 'Wfdoxz'),
   ('d94f0a14-7a20-49fb-a94e-55f42d1e90ec', 'Klgznc', 'Rcjqbv'),
   ('6eeb71d5-27ad-4828-89c2-f524ce370b6c', 'Jndthy', 'Ywtyzj'),
   ('fd5a4035-9b4a-414f-9070-6ec717c3d24b', 'Xwzhsu', 'Jkoitc'),
   ('cf246283-94b5-4815-a55b-1f92f7c12699', 'Bzcfla', 'Ldvckb'),
   ('f21a7b4a-079a-4b57-8bc7-b8c3f2c4f905', 'Xsuqvg', 'Dyfqbg'),
   ('29b6a2f0-6f68-464a-bc7f-4d15be68b90d', 'Pvjmzc', 'Rygqta'),
   ('d1578f65-d8cb-42d6-83c7-48a51b45de8b', 'Teqxjf', 'Lsgfky'),
   ('5fdd058a-39bc-49e6-b09d-0ecfd70287d8', 'Qdpugn', 'Mzdfts'),
   ('ec702b10-c3fc-49f6-91d3-49c23e1c9b45', 'Iwxzfr', 'Gbteqk'),
   ('2a9d5fa2-93fc-4b58-9f83-6ab74220e2c8', 'Elzpmr', 'Vsdyqt'),
   ('2d105d9f-f503-4b5a-b58c-d91e2d202d43', 'Jilxpa', 'Csmkyg'),
   ('2a4784af-6a67-4c47-8326-2a3d5b99f983', 'Pybqmg', 'Hlcgfv'),
   ('47659f2a-b2ae-4b91-83c6-2b94f60a1a35', 'Mlrtzb', 'Hwbvsr'),
   ('cf01e40d-324d-432e-a4af-e4c70dc02e8d', 'Rkznya', 'Dntbfc'),
   ('2f7648d8-5b9e-4a1e-907e-132b308ae957', 'Skdvct', 'Gykqft'),
   ('456ab94d-02a3-4070-a6f2-bd1a6e3d9c3f', 'Tlcuzk', 'Dlnyvp'),
   ('802d2979-fb99-4b1d-bbe7-dfb2eb847349', 'Dziukw', 'Nlptjh'),
   ('4f7f8b82-15d2-4448-92b6-81ac704bddcd', 'Qnpfmr', 'Swgmnd'),
   ('b7852b92-0b5c-4829-99c9-378a9f3c3b48', 'Bdfuqy', 'Lbsgyv'),
   ('60c94ec1-8105-423b-8e7d-5d88996e0b35', 'Ylgmro', 'Jkzvfo'),
   ('b90f47f5-77e4-466f-b2d5-03bfc2e45806', 'Ulgiev', 'Qlykjf'),
   ('23ae42fc-3d82-40e2-8e4b-fc83e18e1cf7', 'Hlvonz', 'Asrgml');

COMMIT;



