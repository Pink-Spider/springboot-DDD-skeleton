# Spring Boot DDD Skeleton

Domain-Driven Design(DDD) 아키텍처를 적용한 Spring Boot 프로젝트 스켈레톤입니다.

## DDD(Domain-Driven Design)란?

DDD는 Eric Evans가 2003년 저서 "Domain-Driven Design: Tackling Complexity in the Heart of Software"에서 소개한 소프트웨어 설계 방법론입니다.

### 핵심 철학

**"소프트웨어의 복잡성은 기술이 아니라 도메인에서 온다"**

DDD는 비즈니스 도메인을 소프트웨어의 중심에 두고, 도메인 전문가와 개발자가 공통의 언어(Ubiquitous Language)로 소통하며 모델을 발전시켜 나가는 것을 강조합니다.

### DDD의 핵심 개념

| 개념 | 설명 |
|------|------|
| **Ubiquitous Language** | 도메인 전문가와 개발자가 공유하는 공통 언어 |
| **Bounded Context** | 특정 모델이 적용되는 명확한 경계 |
| **Entity** | 고유 식별자를 가지며 생명주기를 갖는 객체 |
| **Value Object** | 식별자 없이 속성 값으로만 정의되는 불변 객체 |
| **Aggregate** | 일관성을 유지해야 하는 Entity와 Value Object의 집합 |
| **Repository** | Aggregate의 영속성을 담당하는 추상화 계층 |
| **Domain Service** | 특정 Entity에 속하지 않는 도메인 로직 |
| **Application Service** | 유스케이스를 조율하는 서비스 |

## 프로젝트 구조

```
src/main/java/io/pinkspider/dddskeleton/
├── api/                    # Presentation Layer (Controllers)
│   ├── board/
│   ├── order/
│   ├── product/
│   └── user/
├── application/            # Application Layer (Services)
│   ├── board/
│   ├── order/
│   ├── product/
│   └── user/
├── domain/                 # Domain Layer (Entities, Repository Interfaces)
│   ├── board/
│   ├── order/
│   ├── product/
│   └── user/
├── infrastructure/         # Infrastructure Layer (Repository Implementations)
│   ├── board/
│   ├── order/
│   ├── product/
│   └── user/
├── common/                 # Cross-cutting Concerns
│   ├── exception/
│   └── utils/
├── config/                 # Spring Configuration
└── main/                   # Application Entry Point
```

## 레이어별 책임

### Presentation Layer (`api/`)
- HTTP 요청/응답 처리
- 입력 유효성 검증
- DTO 변환
- 클라이언트와의 통신 프로토콜 관리

### Application Layer (`application/`)
- 유스케이스 구현 및 조율
- 트랜잭션 관리
- 도메인 객체 간의 협력 조정
- 외부 시스템과의 통합

### Domain Layer (`domain/`)
- 핵심 비즈니스 로직
- Entity, Value Object 정의
- Repository 인터페이스 정의
- 도메인 이벤트

### Infrastructure Layer (`infrastructure/`)
- Repository 구현체
- 외부 시스템 연동
- 기술적 구현 세부사항

## 의존성 규칙

```
api → application → domain ← infrastructure
```

- **Domain Layer는 어떤 레이어에도 의존하지 않습니다**
- Infrastructure Layer는 Domain Layer의 인터페이스를 구현합니다
- 의존성은 항상 안쪽(Domain)을 향합니다

## 기술 스택

- Java 24
- Spring Boot 3.4.4
- Gradle 8.14.1

## 시작하기

### 요구사항
- Java 24
- Gradle 8.14+

### 빌드
```bash
./gradlew build
```

### 실행
```bash
./gradlew bootRun
```

### API 엔드포인트

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users?id={id}&name={name}` | 사용자 생성 |
| POST | `/boards?id={id}&name={name}` | 게시판 생성 |
| POST | `/products?id={id}&name={name}` | 상품 생성 |
| POST | `/orders?id={id}&name={name}` | 주문 생성 |

## DDD 적용 가이드

### 1. 도메인 모델링 시작하기

```java
// Domain Entity 예시
public class Order {
    private OrderId id;
    private CustomerId customerId;
    private List<OrderLine> orderLines;
    private OrderStatus status;

    public void place() {
        // 비즈니스 규칙 검증
        // 상태 변경
    }
}
```

### 2. Repository 패턴 적용

```java
// Domain Layer - 인터페이스 정의
public interface OrderRepository {
    Order findById(OrderId id);
    void save(Order order);
}

// Infrastructure Layer - 구현체
@Repository
public class JpaOrderRepository implements OrderRepository {
    // JPA를 사용한 구현
}
```

### 3. Application Service 작성

```java
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void placeOrder(PlaceOrderCommand command) {
        Order order = Order.create(command);
        order.place();
        orderRepository.save(order);
    }
}
```

## 참고 자료

- [Domain-Driven Design Reference](https://www.domainlanguage.com/ddd/reference/) - Eric Evans
- [Implementing Domain-Driven Design](https://www.amazon.com/Implementing-Domain-Driven-Design-Vaughn-Vernon/dp/0321834577) - Vaughn Vernon
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) - Robert C. Martin

## License

MIT License
