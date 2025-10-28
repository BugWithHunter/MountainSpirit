<template>
  <div>
    <!-- 메인 Hero -->
    <main>
      <div class="hero-section d-flex justify-content-center align-items-center">
        <!-- 배경 이미지 레이어 (겹쳐서 페이드 전환) -->
        <div
          v-for="(image, index) in images"
          :key="index"
          class="hero-bg"
          :style="{ backgroundImage: `url(${image})`, opacity: index === currentIndex ? 1 : 0 }"
        ></div>

        <!-- 어두운 오버레이 -->
        <div class="overlay"></div>

        <!-- 텍스트 -->
        <div class="col-md-6 text-white text-center position-relative">
          <h1 class="display-1 fw-bold">산 신 령</h1>
          <h3 class="fw-normal mb-3">당신의 동반자</h3>
        </div>
      </div>

      <!-- 반복되는 제품 섹션 (예시 2개만) -->
      <div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">
        <div class="text-bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
          <div class="my-3 py-3">
            <h2 class="display-5">Another headline</h2>
            <p class="lead">And an even wittier subheading.</p>
          </div>
          <div
            class="bg-body-tertiary shadow-sm mx-auto"
            style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"
          ></div>
        </div>
        <div class="bg-body-tertiary me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
          <div class="my-3 p-3">
            <h2 class="display-5">Another headline</h2>
            <p class="lead">And an even wittier subheading.</p>
          </div>
          <div
            class="bg-dark shadow-sm mx-auto"
            style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"
          ></div>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue'

const images = [
  'https://images.unsplash.com/photo-1501785888041-af3ef285b470',
  'https://images.unsplash.com/photo-1500530855697-b586d89ba3ee',
  'https://fastly.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68',
  'https://fastly.picsum.photos/id/11/2500/1667.jpg?hmac=xxjFJtAPgshYkysU_aqx2sZir-kIOjNR9vx0te7GycQ',
  'https://fastly.picsum.photos/id/15/2500/1667.jpg?hmac=Lv03D1Y3AsZ9L2tMMC1KQZekBVaQSDc1waqJ54IHvo4',
  'https://fastly.picsum.photos/id/29/4000/2670.jpg?hmac=rCbRAl24FzrSzwlR5tL-Aqzyu5tX_PA95VJtnUXegGU'
]

const currentIndex = ref(0)
let timer = null

onMounted(() => {
  timer = setInterval(() => {
    currentIndex.value = (currentIndex.value + 1) % images.length
  }, 4000) // 4초마다 이미지 전환
})

onBeforeUnmount(() => {
  clearInterval(timer)
})
</script>

<style scoped>
/* Hero 섹션 전체 컨테이너 */
.hero-section {
  position: relative;
  height: 100vh;
  overflow: hidden;
}

/* 배경 이미지 레이어 */
.hero-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  transition: opacity 0.8s ease-in-out; /* ✨ 자연스럽게 전환 */
  opacity: 0;
}

/* 어두운 반투명 오버레이 */
.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
}

/* 텍스트 레이어 */
.text-center {
  z-index: 2;
  position: relative;
}
</style>
