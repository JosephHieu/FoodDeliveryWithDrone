import { Swiper, SwiperSlide } from "swiper/react";
import { Autoplay, Pagination } from "swiper/modules";

import "swiper/css";
import "swiper/css/pagination";
import CategorySection from "./CategorySection";

function MainBanner() {
  const banners = [
    { id: 1, url: "/images/banners/banner2.png", alt: "Banner 1" },
    { id: 2, url: "/images/banners/banner1.png", alt: "Banner 2" },
    { id: 3, url: "/images/banners/banner6.png", alt: "Banner 3" },
  ];

  return (
    <section className="mb-[40px] text-black">
      <Swiper
        modules={[Autoplay, Pagination]}
        autoplay={{ delay: 3000, disableOnInteraction: false }}
        loop={true}
        pagination={{ clickable: true }}
        className="h-96"
      >
        {banners.map((banner) => (
          <SwiperSlide key={banner.id}>
            <div
              className="relative w-full h-96 flex items-center justify-center"
              style={{
                backgroundImage: `url('${banner.url}')`,
                backgroundSize: "cover",
                backgroundPosition: "center",
              }}
            >
              {/* Overlay mờ */}
              <div className="absolute inset-0"></div>

              {/* Nội dung */}
              {/* <div className="relative z-10 text-center">
                <h1 className="text-4xl md:text-5xl font-bold text-white mb-4 leading-tight">
                  Hưởng thức món ngon
                </h1>

                <a
                  href="#menu"
                  className="bg-[#C62028] text-white px-4 py-2 rounded-button text-[0.9rem] font-semibold transition-colors"
                >
                  Thực đơn
                </a>
              </div> */}
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
      <CategorySection />
    </section>
  );
}

export default MainBanner;
