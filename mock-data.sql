START TRANSACTION;

INSERT INTO `region` (`id`, `name`) VALUES
(1, '서울 마포구'),
(2, '서울 강남구'),
(3, '서울 성동구')
ON DUPLICATE KEY UPDATE `name` = VALUES(`name`);

INSERT INTO `user`
(`id`, `name`, `email`, `gender`, `birth`, `address`, `created_at`, `updated_at`, `deleted_at`,
 `notice_marketing`, `notice_reply_review`, `notice_reply_qna`)
VALUES
(1, '김동현', 'donghyun@example.com', 1, '1999-03-12', '서울 마포구 연남동',
 '2026-05-01 10:00:00', '2026-05-01 10:00:00', NULL, TRUE, TRUE, FALSE),
(2, '이서연', 'seoyeon@example.com', 2, '2000-07-21', '서울 강남구 역삼동',
 '2026-05-02 11:30:00', '2026-05-02 11:30:00', NULL, FALSE, TRUE, TRUE),
(3, '박민준', 'minjun@example.com', 1, '1998-11-05', '서울 성동구 성수동',
 '2026-05-03 09:20:00', '2026-05-03 09:20:00', NULL, TRUE, FALSE, TRUE)
ON DUPLICATE KEY UPDATE
`name` = VALUES(`name`),
`email` = VALUES(`email`),
`gender` = VALUES(`gender`),
`birth` = VALUES(`birth`),
`address` = VALUES(`address`),
`updated_at` = VALUES(`updated_at`),
`deleted_at` = VALUES(`deleted_at`),
`notice_marketing` = VALUES(`notice_marketing`),
`notice_reply_review` = VALUES(`notice_reply_review`),
`notice_reply_qna` = VALUES(`notice_reply_qna`);

INSERT INTO `food` (`id`, `name`) VALUES
(1, '한식'),
(2, '일식'),
(3, '양식'),
(4, '분식')
ON DUPLICATE KEY UPDATE `name` = VALUES(`name`);

INSERT INTO `food_taste` (`id`, `id_food`, `id_user`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 2, 2),
(4, 3, 2),
(5, 1, 3),
(6, 4, 3)
ON DUPLICATE KEY UPDATE
`id_food` = VALUES(`id_food`),
`id_user` = VALUES(`id_user`);

INSERT INTO `restaurant` (`id`, `name`, `address`, `owner_id`, `id_region`) VALUES
(1, '연남김치찜', '서울 마포구 연남로 12', 'owner-001', 1),
(2, '역삼스시', '서울 강남구 테헤란로 101', 'owner-002', 2),
(3, '성수파스타', '서울 성동구 성수이로 45', 'owner-003', 3)
ON DUPLICATE KEY UPDATE
`name` = VALUES(`name`),
`address` = VALUES(`address`),
`owner_id` = VALUES(`owner_id`),
`id_region` = VALUES(`id_region`);

INSERT INTO `mission` (`id`, `min_order_amount`, `reward`, `id_restaurant`) VALUES
(1, 15000, 1000, 1),
(2, 20000, 1500, 2),
(3, 18000, 1200, 3)
ON DUPLICATE KEY UPDATE
`min_order_amount` = VALUES(`min_order_amount`),
`reward` = VALUES(`reward`),
`id_restaurant` = VALUES(`id_restaurant`);

INSERT INTO `user_mission` (`id`, `mission_id`, `user_id`, `completed`) VALUES
(1, 1, 1, FALSE),
(2, 2, 1, TRUE),
(3, 2, 2, FALSE),
(4, 3, 2, TRUE),
(5, 1, 3, TRUE),
(6, 3, 3, FALSE)
ON DUPLICATE KEY UPDATE
`mission_id` = VALUES(`mission_id`),
`user_id` = VALUES(`user_id`),
`completed` = VALUES(`completed`);

INSERT INTO `review` (`id`, `star`, `content`, `id_restaurant`, `id_user`) VALUES
(1, 4.5, '김치찜이 부드럽고 양도 넉넉했어요.', 1, 1),
(2, 5.0, '초밥 신선도가 좋아서 재주문하고 싶어요.', 2, 2),
(3, 4.0, '파스타 소스가 진하고 분위기도 좋았습니다.', 3, 3)
ON DUPLICATE KEY UPDATE
`star` = VALUES(`star`),
`content` = VALUES(`content`),
`id_restaurant` = VALUES(`id_restaurant`),
`id_user` = VALUES(`id_user`);

INSERT INTO `reply` (`id`, `content`, `id_review`) VALUES
(1, '방문해 주셔서 감사합니다. 더 좋은 맛으로 보답하겠습니다.', 1),
(2, '좋은 리뷰 감사합니다. 다음에도 신선하게 준비하겠습니다.', 2),
(3, '소중한 후기 감사합니다. 또 찾아주세요.', 3)
ON DUPLICATE KEY UPDATE
`content` = VALUES(`content`),
`id_review` = VALUES(`id_review`);

INSERT INTO `notice` (`id`, `title`, `content`, `time_noticed`, `id_user`) VALUES
(1, '미션 참여 안내', '새로운 음식점 미션이 등록되었습니다.', '2026-05-04 09:00:00', 1),
(2, '리뷰 답글 알림', '작성하신 리뷰에 사장님 답글이 달렸습니다.', '2026-05-04 10:15:00', 2),
(3, '포인트 적립 안내', '미션 완료 보상 포인트가 적립되었습니다.', '2026-05-04 11:30:00', 3)
ON DUPLICATE KEY UPDATE
`title` = VALUES(`title`),
`content` = VALUES(`content`),
`time_noticed` = VALUES(`time_noticed`),
`id_user` = VALUES(`id_user`);

UPDATE `food_seq` SET `next_val` = GREATEST(`next_val`, 5);
UPDATE `restaurant_seq` SET `next_val` = GREATEST(`next_val`, 4);
UPDATE `review_seq` SET `next_val` = GREATEST(`next_val`, 4);
UPDATE `reply_seq` SET `next_val` = GREATEST(`next_val`, 4);
UPDATE `notice_seq` SET `next_val` = GREATEST(`next_val`, 4);
UPDATE `user_mission_seq` SET `next_val` = GREATEST(`next_val`, 7);

COMMIT;
