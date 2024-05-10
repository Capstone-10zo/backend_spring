package project.capstone.repository.disease;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.capstone.domain.disease.Disease_info;

@Repository
@Transactional
@RequiredArgsConstructor
public class DiseaseRepository {

    private final DiseaseRepositoryJpa repositoryJpa;

    @PostConstruct
    public void diseaseDescription(){
        Disease_info cataract = new Disease_info("cataract",
                "강아지 백내장은 눈의 수정체가 흐려지거나 불투명해져 시력에 장애를 주는 질환입니다.\\n" +
                        "원인: -유전: 강아지의 종류에 따라 유전적 요인으로 인하여 백내장이 발병할 위험이 더 높을 수 있습니다. 대표적인 견종으로는 푸들, 슈나우저, 코카스패니얼, 시츄, 시베리아허스키 등이 백내장에 걸리기 쉬운 것으로 알려져 있습니다.\n" +
                        "-노화: 강아지가 나이가 들면서, 수정체의 단백질이 분해되어 백내장 형성의 위험을 증가시킬 수 있습니다.\\n" +
                        "-생활 환경: 자외선, 독성 물질 등 일부 환경적 요인에 노출되는 것 또한 강아지의 백내장 형성에 영향을 줄 수 있습니다.\\n" +
                        "치료: 수술은 강아지 백내장에 가장 효과적인 치료 방법입니다. 백내장이 강아지의 시력을 크게 저하시켜 삶의 질에 영향을 끼친다고 판단이 된다면 수술을 통한 치료가 권장됩니다.\\n" +
                        "예방: 정기적인 시력검사, 균형 잡힌 영양 제공, 당뇨병의 초기 징후 관찰, 눈 부상과 자극 위험 줄이기");
        Disease_info conjunctivitis = new Disease_info("conjunctivitis",
                "강아지 결막염은 눈꺼풀의 안쪽과 흰 눈의 표면(공막)으로 이루어진 결막에 염증이 생긴 질병을 의미합니다. 강아지에게 발생하는 안과 질환 중 가장 잦게 나타나는 질병으로 알려져있습니다.\\n" +
                        "원인: -세균: 강아지들은 상대적으로 사람보다 지면에 가깝게 생활하기 때문에 주변 세균으로부터 침입을 받기 쉽습니다.\\n" +
                        "-이물질: 집먼지 또는 산책 시 미세먼지, 꽃가루 등 강아지 눈에 어떠한 이물질이 들어간 경우에도 결막염이 발생할 수 있습니다.\\n" +
                        "-마찰: 강아지가 눈을 긁는 등 눈에 마찰이 가해지면 안구에 상처가 나거나 실핏줄이 터져 결막염이 발생할 수 있습니다\\n" +
                        "치료: 이미 결막염이 발생되었다면 병원에서 안약을 처방받아 주기적으로 넣어주는 것이 좋습니다.\\n" +
                        "예방: 평상시에 눈이 건조하지 않도록 눈 주변 주기적으로 닦아주고, 가습기, 공기청정기 등을 활용해 습도 조절에 신경써주시기 바랍니다.\\n"
        );

        Disease_info entropion = new Disease_info("entropion",
                "강아지 안검내반증은 안검내반은 눈꺼풀과 속눈썹이 눈 안쪽으로 감겨 있는 상태를 말합니다. 눈을 잘 못 뜨거나 눈물이 많아지는 문제가 발생합니다.\\n" +
                        "원인: -유전: 선천적인 원인이 많은 질환입니다.\\n" +
                        "-통증, 노화: 통증으로 인한 눈꺼풀 경련 혹은 노령으로 안구 주변 근육이 약해져서 일어나는 경우등이 있습니다.\\n" +
                        "치료: 초기에 발견한다면 빠르게 치료가 가능한 병으로 병원에서 검사를 받는 것이 좋습니다.\\n" +
                        "예방: 초기에 병원을 방문하는 것을 추천드립니다.\\n");

        Disease_info epiphora = new Disease_info("epiphora",
                "강아지 유루증은 눈 주변의 털이 지속적으로 축축해지고 붉은색으로 변하는 현상을 말합니다.\\n" +
                        "원인: -내부: 눈물을 코로 배출시켜주는 코 눈물관(비루관)이 기능을 제대로 수행하지 못 한 경우.\\n" +
                        "-병력: 각막염이나 결막염을 앓았던 적이 있는 경우.\\n" +
                        "치료: 가까운 병원에서 검사를 받는 것이 좋습니다.\\n" +
                        "예방: 미관상의 문제 뿐만 아니라 세균이 자라기 좋은 환경을 제공하기 때문에 항상 눈 주위를 청결하게 해줘야 합니다.\\n");

        Disease_info nuclearSclerosis = new Disease_info("nuclear_sclerosis",
                "강아지 핵경화는 주로 백내장과 혼동되며 노화가 진행됨에 따라 발생하는 질병입니다. 사람의 머리카락이 희게 변하는 것과 비슷한 현상으로 시력이나 다른 곳에 영향을 주지 않습니다.\\n" +
                        "원인: -내부: 새로운 섬유질이 생성됨에 따라 수정체의 중심부에 오래된 섬유질들이 밀집되어 발생한다. 수정체의 밀도가 변하면서 시각적으로 그 변화가 드러난 경우.\\n" +
                        "치료: 백내장과 달리 노화가 진행 됨에 빠라 발생하는 질병이기 때문에 치료법이 존재하지 않습니다.\\n" +
                        "예방: 마찬가지로 노화가 원인이기 때문에 별다는 예방법이 존재하지 않습니다.\\n");

        Disease_info blepharoncus = new Disease_info("blepharoncus",
                "");
        Disease_info corneal_ulcer = new Disease_info("corneal_ulcer",
                "");
        Disease_info noncorneal_ulcer = new Disease_info("noncorneal_ulcer",
                "");
        Disease_info eye_cancer = new Disease_info("eye_cancer",
                "");
        Disease_info pigmentary_keratitis = new Disease_info("pigmentary_keratitis",
                "");

        repositoryJpa.save(cataract);
        repositoryJpa.save(conjunctivitis);
        repositoryJpa.save(entropion);
        repositoryJpa.save(epiphora);
        repositoryJpa.save(nuclearSclerosis);
        repositoryJpa.save(blepharoncus);
        repositoryJpa.save(corneal_ulcer);
        repositoryJpa.save(noncorneal_ulcer);
        repositoryJpa.save(eye_cancer);
        repositoryJpa.save(pigmentary_keratitis);
    }
}
